package com.pranavacharya.spoj;

import java.util.Scanner;

public class ALTSEQ {

    public int longALtSeq(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(arr[i]) > Math.abs(arr[j])
                        && ((arr[i] > 0 && arr[j] < 0) || (arr[i] < 0 && arr[j] > 0))) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String args[]) {
        ALTSEQ a = new ALTSEQ();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(a.longALtSeq(arr));
    }
}
