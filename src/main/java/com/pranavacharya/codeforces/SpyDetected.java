package com.pranavacharya.codeforces;

import java.util.Scanner;

public class SpyDetected {

    private int findSpy(int[] arr) {
        if (arr[0] == arr[arr.length - 1]) {
            int x = arr[0];
            for (int i = 1; i < arr.length; i++) {
                x = x ^ arr[i];
                if (x != 0 && x != arr[0]) {
                    return i + 1;
                }
            }
            return -1;
        } else {
            if (arr[0] == arr[1]) {
                return arr.length;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        SpyDetected sd = new SpyDetected();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(sd.findSpy(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
