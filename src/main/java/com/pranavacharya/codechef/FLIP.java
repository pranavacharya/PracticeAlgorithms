package com.pranavacharya.codechef;

import java.util.Scanner;

public class FLIP {

    public int minOps(String a, String b) {
        int[] dp = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }
        int ops = 0;
        int streak = 0;
        for (int i = 0; i < dp.length; i = i + 2) {
            if (dp[i] == 1) {
                streak++;
            } else {
                if (streak > 0) {
                    ops++;
                }
                streak = 0;
            }
        }
        if (streak > 0) {
            ops++;
        }
        streak = 0;
        for (int i = 1; i < dp.length; i = i + 2) {
            if (dp[i] == 1) {
                streak++;
            } else {
                if (streak > 0) {
                    ops++;
                }
                streak = 0;
            }
        }
        if (streak > 0) {
            ops++;
        }
        return ops;
    }

    public static void main(String args[]) {
        FLIP f = new FLIP();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            sb.append(f.minOps(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
