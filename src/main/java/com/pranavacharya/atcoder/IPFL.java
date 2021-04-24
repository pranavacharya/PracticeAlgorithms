package com.pranavacharya.atcoder;

import java.util.Scanner;

public class IPFL {

    private String runQueries(String s, int[][] queries) {
        int n = s.length() / 2;
        int i = 0;
        int j = n;
        char[] arr = s.toCharArray();
        for (int k = 0; k < queries.length; k++) {
            int t = queries[k][0];
            int a = queries[k][1] - 1;
            int b = queries[k][2] - 1;
            if (t == 1) {
                if (i == 0) {
                    char temp = arr[i + a];
                    arr[i + a] = arr[i + b];
                    arr[i + b] = temp;
                } else {
                    int firstIndex = -1;
                    if (a >= n) {
                        firstIndex = j + (a - n);
                    } else {
                        firstIndex = i + a;
                    }
                    int secondIndex = -1;
                    if (b >= n) {
                        secondIndex = j + (b - n);
                    } else {
                        secondIndex = i + b;
                    }
                    char temp = arr[firstIndex];
                    arr[firstIndex] = arr[secondIndex];
                    arr[secondIndex] = temp;
                }
            } else {
                int temp = i;
                i = j;
                j = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < (i + n); k++) {
            sb.append(arr[k]);
        }
        for (int k = j; k < (j + n); k++) {
            sb.append(arr[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IPFL ipfl = new IPFL();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int q = sc.nextInt();
        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }
        System.out.println(ipfl.runQueries(s, queries));
    }
}
