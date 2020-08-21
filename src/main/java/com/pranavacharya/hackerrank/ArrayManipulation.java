package com.pranavacharya.hackerrank;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        long[] da = new long[n + 2];
        for (int[] q : queries) {
            int x = q[0];
            int y = q[1];
            int k = q[2];
            da[x] += k;
            da[y + 1] -= k;
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + da[i];
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String args[]) {
        int[][] queries = new int[][]{{2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}};
        System.out.println(arrayManipulation(10, queries));
    }
}
