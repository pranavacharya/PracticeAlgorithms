package com.pranavacharya.spoj;

import java.util.Scanner;

public class ACODE {

    public int findPossible(String n) {
        if (n.length() == 0) {
            return 0;
        }
        if (n.length() == 1) {
            return 1;
        }
        int[] dp = new int[n.length()];
        dp[0] = 1;
        dp[1] = ((n.charAt(1) < '7' && n.charAt(0) == '2' || n.charAt(1) > '0' && n.charAt(0) == '1'))
                && n.charAt(1) > '0' && n.charAt(1) > '0' ? 2 : 1;
        if (n.charAt(1) == '0' && n.charAt(0) > '2') {
            return 0;
        }
        for (int i = 2; i < dp.length; i++) {
            if ((n.charAt(i) < '7' && n.charAt(i - 1) == '2' || n.charAt(i) > '0' && n.charAt(i - 1) == '1')
                    && n.charAt(i) > '0' && n.charAt(i - 1) > '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (n.charAt(i) == '0') {
                if (n.charAt(i - 1) == '1' || n.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String args[]) {
        ACODE a = new ACODE();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }
            sb.append(a.findPossible(input)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
