package com.pranavacharya.codeforces;

import java.util.Scanner;

public class DominantPiranha {

    public int findDominant(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                if (i != 0 && i != arr.length - 1) {
                    if (arr[i] > arr[i + 1] || arr[i] > arr[i - 1]) {
                        return i + 1;
                    }
                }
                if (i == 0 && i + 1 < arr.length) {
                    if (arr[i] > arr[i + 1]) {
                        return i + 1;
                    }
                }
                if (i == arr.length - 1 && i - 1 >= 0) {
                    if (arr[i] > arr[i - 1]) {
                        return i + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        DominantPiranha dp = new DominantPiranha();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(dp.findDominant(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
