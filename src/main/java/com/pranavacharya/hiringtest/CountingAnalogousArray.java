package com.pranavacharya.hiringtest;

import java.util.Scanner;

public class CountingAnalogousArray {

    private long countArray(int[] da, int low, int high) {

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < da.length; i++) {
            sum += (-1 * da[i]);
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        long result = high - low - (max - min);
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        CountingAnalogousArray caa = new CountingAnalogousArray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] da = new int[n];
        for (int i = 0; i < n; i++) {
            da[i] = sc.nextInt();
        }
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(caa.countArray(da, low, high));
    }
}
