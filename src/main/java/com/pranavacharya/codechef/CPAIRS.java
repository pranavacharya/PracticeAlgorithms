package com.pranavacharya.codechef;

import java.util.Scanner;

public class CPAIRS {

    public int findNumberOfPairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] % 2 == 0 && arr[j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CPAIRS c = new CPAIRS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.findNumberOfPairs(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
