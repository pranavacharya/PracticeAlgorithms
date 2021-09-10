package com.pranavacharya.hackerrank;

import java.util.Scanner;

public class TrickorTreat {

    private int findMaxCandies(int total, int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] <= total && arr[i] + arr[j] > max) {
                    max = arr[i] + arr[j];
                }
                if (arr[i] <= total && arr[i] > max) {
                    max = arr[i];
                }
                if (arr[j] <= total && arr[j] > max) {
                    max = arr[j];
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        TrickorTreat tt = new TrickorTreat();
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(tt.findMaxCandies(total, arr));
    }
}
