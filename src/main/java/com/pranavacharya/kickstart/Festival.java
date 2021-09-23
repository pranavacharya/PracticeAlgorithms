package com.pranavacharya.kickstart;

import java.util.Arrays;
import java.util.Scanner;

public class Festival {

    private int maxHappy(int d, int k, int[][] arr) {
        Arrays.sort(arr, (a, b) -> (b[0] - a[0]));
        int max = 0;
        for (int i = 1; i <= d; i++) {
            int count = 0;
            int local = 0;
            for (int j = 0; j < arr.length; j++) {
                if (count == k) {
                    break;
                }
                if (i >= arr[j][1] && i <= arr[j][2]) {
                    local += arr[j][0];
                    count++;
                }
            }
            max = Math.max(max, local);
        }
        return max;
    }

    public static void main(String[] args) {
        Festival f = new Festival();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                arr[j][2] = sc.nextInt();
            }
            sb.append("Case #" + (i + 1) + ": " + f.maxHappy(d, k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
