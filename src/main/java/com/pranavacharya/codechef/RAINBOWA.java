package com.pranavacharya.codechef;

import java.util.Scanner;

public class RAINBOWA {

    public String isRainbow(int[] arr) {
        int last = 0;
        for (int i = 0; i <= arr.length / 2; i++) {
            if (arr[i] > 7 || (i == arr.length / 2 && arr[i] != 7)) {
                return "no";
            }
            if (arr[i] != last && arr[i] != last + 1) {
                return "no";
            }
            if (arr[i] != arr[arr.length - 1 - i]) {
                return "no";
            }
            last = arr[i];
        }
        return "yes";
    }

    public static void main(String args[]) {
        RAINBOWA r = new RAINBOWA();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(r.isRainbow(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
