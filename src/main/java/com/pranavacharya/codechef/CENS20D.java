package com.pranavacharya.codechef;

import java.util.Scanner;

public class CENS20D {

    public int noPairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) == arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CENS20D c = new CENS20D();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.noPairs(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
