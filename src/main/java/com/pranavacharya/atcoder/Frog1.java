package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Frog1 {

    private int findMinCost(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            dp[i] = Math.min(dp[i], dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Frog1 f = new Frog1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(f.findMinCost(n, arr));
    }
}
