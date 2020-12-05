package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class VACCINE2 {

    public int findMinDays(int[] arr, int d) {
        Arrays.sort(arr);
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10) {
                start = i;
                break;
            }
        }

        int end = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= 79) {
                end = i;
                break;
            }
        }

        int count = end - start + 1;
        int risk = arr.length - count;
        int days = 0;
        if (count % d == 0) {
            days += count / d;
        } else {
            days += count / d;
            days++;
        }

        if (risk % d == 0) {
            days += risk / d;
        } else {
            days += risk / d;
            days++;
        }

        return days;
    }

    public static void main(String args[]) {
        VACCINE2 v = new VACCINE2();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int d = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(v.findMinDays(arr, d)).append('\n');
        }
        System.out.println(sb.toString());
    }
}
