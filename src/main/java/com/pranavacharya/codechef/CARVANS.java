package com.pranavacharya.codechef;

import java.util.Scanner;

public class CARVANS {

    public int countCar(int[] arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= min) {
                count++;
            }
            min = Math.min(min, arr[i]);
        }
        return count;
    }

    public static void main(String args[]) {
        CARVANS c = new CARVANS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.countCar(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
