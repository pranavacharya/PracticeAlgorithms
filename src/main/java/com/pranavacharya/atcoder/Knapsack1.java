package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Knapsack1 {

    private long findMaxValue(int n, int[][] items, int w) {
        long[][] dp = new long[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (items[i - 1][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            items[i - 1][1] + dp[i - 1][j - items[i - 1][0]]);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        Knapsack1 k = new Knapsack1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        System.out.println(k.findMaxValue(n, items, w));
    }
}
