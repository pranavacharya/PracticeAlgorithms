package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Stones {

    private boolean isFirstWinner(int[] arr, int k, int n) {
        boolean[] dp = new boolean[k + 1];
        for (int i = 1; i < dp.length; i++) {
            boolean local = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] <= i) {
                    local = local && dp[i - arr[j]];
                }
            }
            dp[i] = !local;
        }
        return dp[k];
    }

    public static void main(String[] args) {
        Stones s = new Stones();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (s.isFirstWinner(arr, k, n)) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}
