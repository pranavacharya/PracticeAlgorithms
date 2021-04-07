package com.pranavacharya.hackerrank;

public class BitwiseAND {

    public static int bitwiseAnd(int N, int K) {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if ((i & j) < K) {
                    max = Math.max(max, i & j);
                }
            }
        }
        return max;
    }
}
