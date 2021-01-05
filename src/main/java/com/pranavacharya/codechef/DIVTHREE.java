package com.pranavacharya.codechef;

import java.util.Scanner;

public class DIVTHREE {

    public int findMaxDiv(int k, int d, int[] arr) {
        int totalProblems = 0;
        for (int i = 0; i < arr.length; i++) {
            totalProblems += arr[i];
        }
        int days = totalProblems / k;
        return Math.min(d, days);
    }

    public static void main(String args[]) {
        DIVTHREE div = new DIVTHREE();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int k = sc.nextInt();
            int d = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(div.findMaxDiv(k, d, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
