package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ANUBTG {

    public int minCost(int[] arr) {
        int cost = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i = i - 4) {
            cost += arr[i];
        }
        for (int i = arr.length - 2; i >= 0; i = i - 4) {
            cost += arr[i];
        }
        return cost;
    }

    public static void main(String args[]) {
        ANUBTG an = new ANUBTG();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(an.minCost(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
