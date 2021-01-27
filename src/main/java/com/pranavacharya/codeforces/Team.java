package com.pranavacharya.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Team {

    private int minTeams(int k, int[] arr) {
        int teams = 0;
        Arrays.sort(arr);
        int i = arr.length - 1;
        for (i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= k) {
                teams++;
            } else {
                break;
            }
        }
        int j = i;
        i = 0;
        for (j = j; j >= 0; j--) {
            while (i < j && arr[i] + arr[j] < k) {
                i++;
            }
            if (i < j) {
                teams++;
                i++;
            } else {
                break;
            }
        }
        return teams;
    }

    public static void main(String args[]) {
        Team tm = new Team();
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
            sb.append(tm.minTeams(k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
