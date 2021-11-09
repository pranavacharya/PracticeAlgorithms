package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class QUALPREL {

    private long findNumberOfTeams(int[] arr, int k) {
        Arrays.sort(arr);
        long count = 0;
        int i = 0;
        for (i = arr.length - 1; i >= 0; i--) {
            if (count == k) {
                break;
            }
            count++;
        }
        int last = arr[i + 1];
        while (i >= 0 && arr[i] == last) {
            count++;
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        QUALPREL q = new QUALPREL();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(q.findNumberOfTeams(arr, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
