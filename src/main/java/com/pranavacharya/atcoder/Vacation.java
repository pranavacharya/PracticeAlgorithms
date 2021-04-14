package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Vacation {

    private int findMaxScore(int[][] arr, int n) {
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        Vacation v = new Vacation();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        System.out.println(v.findMaxScore(arr, n));
    }
}
