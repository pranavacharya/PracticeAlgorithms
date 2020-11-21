package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class TOWIN {

    public String isWinning(int[] arr) {
        Arrays.sort(arr);
        long first = 0;
        long second = 0;
        for (int i = arr.length - 1; i >= 0;) {
            first += arr[i--];
            if (i >= 0) {
                second += arr[i--];
            }
            if (i >= 0 && i == arr.length - 3) {
                second += arr[i--];
            }
        }
        if (first == second) {
            return "draw";
        }
        return first > second ? "first" : "second";
    }

    public static void main(String args[]) {
        TOWIN c = new TOWIN();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.isWinning(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
