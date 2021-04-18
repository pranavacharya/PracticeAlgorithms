package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Deque {

    private long[][] dp;

    private long findMaxDifference(int[] arr) {
        int n = arr.length;
        this.dp = new long[n][n];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
            Arrays.fill(this.dp[i], -1);
        }
        return dfs(0, n - 1, arr);
    }

    private long dfs(int i, int j, int[] arr) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        if (i == j) {
            return this.dp[i][j] = arr[i];
        }
        return this.dp[i][j] = Math.max(arr[i] - dfs(i + 1, j, arr), arr[j] - dfs(i, j - 1, arr));
    }

    public static void main(String[] args) {
        Deque d = new Deque();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(d.findMaxDifference(arr));
    }
}
