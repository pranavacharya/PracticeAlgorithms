package com.pranavacharya.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Password {

    private int MOD = 1_000_000_007;
    private int[][] dp;

    private int noOfWays(String password) {
        dp = new int[10][password.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 1, password);
    }

    private int helper(int pos, int lastVal, String password) {
        if (pos == password.length()) {
            return 1;
        }
        if (dp[lastVal][pos] != -1) {
            return dp[lastVal][pos];
        }
        int ways = 0;
        for (int i = 1; i < 10; i++) {
            if (i < lastVal) {
                continue;
            }
            if (password.charAt(pos) != '-' && password.charAt(pos) != i + '0') {
                continue;
            }
            ways += helper(pos + 1, i, password);
            ways %= MOD;
        }
        return dp[lastVal][pos] = ways;
    }

    public static void main(String args[]) {
        Password pw = new Password();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            sb.append(pw.noOfWays(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
