package com.pranavacharya.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSteps {

    public int minSteps(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        int min = arr.length;
        min = Math.min(min, arr.length - max);
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int val : dp) {
            max = Math.max(max, val);
        }
        min = Math.min(min, arr.length - max);
        return min;
    }

    public static void main(String args[]) {
        MinimumSteps ms = new MinimumSteps();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(ms.minSteps(arr));
//        int[] arr = new int[]{352, 170, 383, 599, 797, 591, 199, 511, 253, 330, 93, 209,
//            311, 167, 355, 882, 351, 290, 461};
//        System.out.println(ms.minSteps(arr));
    }
}
