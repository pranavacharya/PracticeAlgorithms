package com.pranavacharya.codeforces;

import java.util.Scanner;

public class MaximumIncrease {

    private int findMaxIncrease(int[] arr) {
        int max = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            start = end;
            while (end + 1 < arr.length) {
                if (arr[end + 1] > arr[end]) {
                    end++;
                } else {
                    break;
                }
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumIncrease mi = new MaximumIncrease();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mi.findMaxIncrease(arr));
    }
}
