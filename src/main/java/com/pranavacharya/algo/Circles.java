package com.pranavacharya.algo;

public class Circles {

    public int[][] prettyPrint(int A) {
        int n = 2 * A - 1;
        int[][] arr = new int[n][n];
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.max(Math.abs(i - mid), Math.abs(j - mid)) + 1;
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        Circles c = new Circles();
        int[][] arr = c.prettyPrint(5);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.err.print(arr[i][j] + " ");
            }
            System.err.println();
        }
    }
}
