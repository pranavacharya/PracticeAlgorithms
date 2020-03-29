package com.pranavacharya.algo;

public class MaxSumArray {

    public int maxSubsetSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 1]), dp[i - 2]);
        }

        return dp[arr.length - 1];
    }
}
