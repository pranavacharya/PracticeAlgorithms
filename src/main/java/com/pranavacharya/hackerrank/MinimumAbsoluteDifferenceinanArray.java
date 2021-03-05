package com.pranavacharya.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceinanArray {

    private int findMinAbsDiff(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceinanArray mada = new MinimumAbsoluteDifferenceinanArray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mada.findMinAbsDiff(arr));
    }
}
