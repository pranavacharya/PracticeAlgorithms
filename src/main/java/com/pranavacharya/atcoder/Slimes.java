package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Slimes {

    long[][] dp;

    private long findMinCost(long[] arr) {
        this.dp = new long[arr.length][arr.length];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        long[] prefix = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return helper(0, arr.length - 1, prefix, arr);
    }

    private long helper(int i, int j, long[] prefix, long[] arr) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        if (i == j) {
            return this.dp[i][j] = 0;
        }
        if (i + 1 == j) {
            return this.dp[i][j] = arr[i] + arr[j];
        }
        long min = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, helper(i, k, prefix, arr) + helper(k + 1, j, prefix, arr) + prefix[j + 1] - prefix[i]);
        }
        return this.dp[i][j] = min;
    }

    public static void main(String[] args) {
        Slimes s = new Slimes();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(s.findMinCost(arr));
    }
}
