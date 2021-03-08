package com.pranavacharya.hackerearth;

public class DegreeOfFreedom {

    static long solve(int N, int[] A) {
        long[] dp = new long[N + 1];
        for (int i = 0; i < dp.length; i++) {
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            for (int j = i; j > 0; j--) {
                max = Math.max(max, A[j - 1]);
                min = Math.min(min, A[j - 1]);
                dp[i] = Math.max(dp[i], dp[i - 1] + (max - min));
            }
        }
        return dp[N];
    }
}
