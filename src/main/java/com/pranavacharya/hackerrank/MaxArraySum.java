package com.pranavacharya.hackerrank;

import java.util.Scanner;

public class MaxArraySum {

    private int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0] < 0 ? 0 : arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == 1) {
                dp[i] = arr[i] < 0 ? Math.max(dp[i - 1], 0) : arr[i];
                continue;
            }
            dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 2]), dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        MaxArraySum mas = new MaxArraySum();
//        int[] arr = new int[]{-2, 1, 3, -4, 5};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mas.maxSubsetSum(arr));
    }
}
