package com.pranavacharya.spoj;

import java.util.Scanner;

public class ADASEQEN {

    private int findMaxVal(String a, String b, int[] vals) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + vals[a.charAt(i - 1) - 'a'];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String args[]) {
        ADASEQEN ad = new ADASEQEN();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] vals = new int[26];
        for (int i = 0; i < 26; i++) {
            vals[i] = sc.nextInt();
        }
        String a = sc.next();
        String b = sc.next();
        System.out.println(ad.findMaxVal(a, b, vals));
    }
}
