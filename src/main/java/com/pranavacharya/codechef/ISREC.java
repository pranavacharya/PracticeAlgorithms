package com.pranavacharya.codechef;

import java.util.Scanner;

public class ISREC {

    private boolean isValid(String[] arr, int n, int m) {
        int left = m - 1;
        int right = 0;
        int top = n - 1;
        int bottom = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '1') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (arr[i].charAt(j) == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ISREC i = new ISREC();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] arr = new String[n];
            for (int k = 0; k < n; k++) {
                arr[k] = sc.next();
            }
            if (i.isValid(arr, n, m)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
