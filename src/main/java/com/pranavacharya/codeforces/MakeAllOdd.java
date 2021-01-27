package com.pranavacharya.codeforces;

import java.util.Scanner;

public class MakeAllOdd {

    private int minMoves(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount == 0) {
            return -1;
        }
        return arr.length - oddCount;
    }

    public static void main(String args[]) {
        MakeAllOdd dm = new MakeAllOdd();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(dm.minMoves(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
