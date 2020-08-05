package com.pranavacharya.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveSmallest {

    public String isPossible(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String args[]) {
        RemoveSmallest rs = new RemoveSmallest();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(rs.isPossible(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
