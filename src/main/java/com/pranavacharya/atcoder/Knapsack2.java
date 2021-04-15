package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {

    private long findMaxValue(int n, int[][] items, int w) {
        int sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i][1];
        }
        // dp[item][value]
        // find min weight combination to achieve a particular value

        long[][] dp = new long[n + 1][sum + 1];
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][items[0][1]] = items[0][0];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (items[i - 1][1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j - items[i - 1][1]] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], items[i - 1][0] + dp[i - 1][j - items[i - 1][1]]);
                    }
                }
            }
        }

        // find hightest value less than given weight
        for (int i = sum; i >= 0; i--) {
            if (dp[n][i] <= w) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Knapsack2 k = new Knapsack2();
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
