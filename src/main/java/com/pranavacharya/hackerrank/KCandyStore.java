package com.pranavacharya.hackerrank;

import java.util.Scanner;

public class KCandyStore {

    private int[][] dp;
    private int mod = (int) 1e9;

    public KCandyStore() {
        dp = new int[2000][2000];
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }
    }

    public int solve(int n, int k) {
//        n + r - 1 choose r
        return dp[n + k - 1][k];
    }

    public static void main(String args[]) {
        KCandyStore kcs = new KCandyStore();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sb.append(kcs.solve(n, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
