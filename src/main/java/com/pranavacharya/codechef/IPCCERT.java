package com.pranavacharya.codechef;

import java.util.Scanner;

public class IPCCERT {

    public int findEligible(int[][] arr, int m) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int total = 0;
            for (int j = 0; j < arr[i].length - 1; j++) {
                total += arr[i][j];
            }
            if (total >= m && arr[i][arr[i].length - 1] <= 10) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        IPCCERT ip = new IPCCERT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][k + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sb.append(ip.findEligible(arr, m));
        System.out.println(sb.toString());
    }
}
