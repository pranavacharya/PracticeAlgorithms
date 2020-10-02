package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHEFEZQ {

    public long findFirstDay(int[] arr, long k) {
        long queries = 0;
        for (int i = 0; i < arr.length; i++) {
            queries += arr[i];
            if (queries < k) {
                return i + 1;
            } else {
                queries -= k;
            }
        }
        return arr.length + queries / k + 1;
    }

    public static void main(String args[]) {
        CHEFEZQ c = new CHEFEZQ();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.findFirstDay(arr, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
