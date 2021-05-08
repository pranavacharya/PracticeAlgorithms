package com.pranavacharya.hackerearth;

import java.util.HashSet;

public class RotatingBitCoaster2 {

    private long solve(long X, int N, int[] A) {
        long result = 0;
        HashSet<Integer> sums = new HashSet();
        sumOfSubSet(0, A, 0, sums);
        for (int sum : sums) {
            result = Math.max(result, rotateClockwise(X, sum));
        }
        return result;
    }

    private int rotateClockwise(long n, int s) {
        long ans = (n >> s) | (n << (31 - s));
        int res = (int) ans;
        if ((n >> (32 - 1) & 1) == 0) {
            res = (int) ans & ~(1 << (32 - 1));
        } else {
            res = (int) ans | (1 << 32);
        }
        return res;
    }

    private void sumOfSubSet(int index, int[] A, int sum, HashSet<Integer> set) {
        if (index == A.length) {
            set.add(sum);
            return;
        }
        sumOfSubSet(index + 1, A, sum, set);
        sumOfSubSet(index + 1, A, sum + A[index], set);
    }

    public static void main(String[] args) {
        RotatingBitCoaster2 rbc = new RotatingBitCoaster2();
        long x = 7;
        int n = 3;
        int[] A = new int[]{1, 5, 7};
        System.out.println(rbc.solve(x, n, A));
    }
}
