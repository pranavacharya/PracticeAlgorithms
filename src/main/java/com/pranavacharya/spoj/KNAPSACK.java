package com.pranavacharya.spoj;

import java.util.Scanner;

public class KNAPSACK {

    public int findMaxValue(int[][] val, int s) {
        int[][] dp = new int[val.length + 1][s + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (val[i - 1][0] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], val[i - 1][1] + dp[i - 1][j - val[i - 1][0]]);
                    }
                }
            }
        }
        return dp[val.length][s];
    }

    public static void main(String args[]) {
        KNAPSACK k = new KNAPSACK();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[][] val = new int[n][2];
        for (int i = 0; i < n; i++) {
            val[i][0] = sc.nextInt();
            val[i][1] = sc.nextInt();
        }
        System.out.println(k.findMaxValue(val, s));
    }
}
