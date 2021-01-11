package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class WIPL {

    public int findMinBoxes(int k, int[] arr) {
        int minBoxes = 0;
        int[] suff = new int[arr.length];
        int sum = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            suff[i] = sum + arr[i];
            sum += arr[i];
        }
        int[][] dp = new int[arr.length + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0;
                    j--) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j <= arr[i]) {
                    dp[i][j] = arr[i];
                } else {
                    if (dp[i + 1][j - arr[i]] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], arr[i] + dp[i + 1][j - arr[i]]);
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        for (int i = arr.length - 1; i >= 0; i--) {
            if (suff[i] - dp[i][k] >= k) {
                return arr.length - i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        WIPL w = new WIPL();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(w.findMinBoxes(k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
