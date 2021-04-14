package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {

    private int findMinCost(int n, int[] arr, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1, c = k; j >= 0 && c > 0; j--, c--) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(arr[i] - arr[j]));
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Frog2 f = new Frog2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(f.findMinCost(n, arr, k));
    }
}
