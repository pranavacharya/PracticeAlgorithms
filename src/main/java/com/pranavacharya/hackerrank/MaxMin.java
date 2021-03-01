package com.pranavacharya.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

    private int findMaxMin(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        int ans = arr[arr.length - 1] - arr[0];
        while (j < arr.length) {
            if (j - i + 1 == k) {
                ans = Math.min(ans, arr[j] - arr[i]);
            }
            if (j - i + 1 > k) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        MaxMin mm = new MaxMin();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mm.findMaxMin(arr, k));
    }
}
