package com.pranavacharya.codeforces;

import java.util.Scanner;

public class AlmostRectangle {

    private String genRect(int n, String[] arr) {
        int m = arr[0].length();
        StringBuilder sb = new StringBuilder();
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '*') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }
        int x3 = -1;
        int y3 = -1;
        int x4 = -1;
        int y4 = -1;
        if (x1 != x2) {
            x3 = x1;
            x4 = x2;
        } else {
            if (x1 == 0) {
                x3 = n - 1;
                x4 = n - 1;
            } else if (x1 == n - 1) {
                x3 = 0;
                x4 = 0;
            } else {
                x3 = 0;
                x4 = 0;
            }
        }
        if (y1 != y2) {
            y3 = y2;
            y4 = y1;
        } else {
            if (y1 == 0) {
                y3 = m - 1;
                y4 = m - 1;
            } else if (y1 == m - 1) {
                y3 = 0;
                y4 = 0;
            } else {
                y3 = 0;
                y4 = 0;
            }
        }
        char[] s3 = arr[x3].toCharArray();
        s3[y3] = '*';
        arr[x3] = new String(s3);
        char[] s4 = arr[x4].toCharArray();
        s4[y4] = '*';
        arr[x4] = new String(s4);
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlmostRectangle ar = new AlmostRectangle();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.next();
            }
            sb.append(ar.genRect(n, arr));
        }
        System.out.println(sb.toString());
    }
}
