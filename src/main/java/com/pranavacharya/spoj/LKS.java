package com.pranavacharya.spoj;

import java.util.Scanner;

public class LKS {

    public int findMaxWeight(int[][] val, int k) {
        int[][] dp = new int[2][k + 1];
        for (int i = 0; i < val.length; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= k; j++) {
                    if (val[i][1] > j) {
                        dp[0][j] = dp[1][j];
                    } else {
                        dp[0][j] = Math.max(dp[1][j], val[i][0] + dp[1][j - val[i][1]]);
                    }
                }
            } else {
                for (int j = 1; j <= k; j++) {
                    if (val[i][1] > j) {
                        dp[1][j] = dp[0][j];
                    } else {
                        dp[1][j] = Math.max(dp[0][j], val[i][0] + dp[0][j - val[i][1]]);
                    }
                }
            }
        }
        return val.length % 2 != 0 ? dp[0][k] : dp[1][k];
    }

    public static void main(String args[]) {
        LKS l = new LKS();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] val = new int[n][2];
        for (int i = 0; i < n; i++) {
            val[i][0] = sc.nextInt();
            val[i][1] = sc.nextInt();
        }
        System.out.println(l.findMaxWeight(val, k));
    }
}
