package com.pranavacharya.codeforces;

import java.util.Scanner;

public class Shuffle {

    public int numberOfIndices(int n, int x, int[][] query) {
        int low = x;
        int high = x;
        for (int[] q : query) {
            int start = q[0];
            int end = q[1];
            if (start <= low && end >= high) {
                low = start;
                high = end;
            } else if (start <= low && start <= high && end >= low && end <= high) {
                low = start;
            } else if (start <= high && start >= low && end >= high && end >= low) {
                high = end;
            }
        }
        return (high - low + 1);
    }

    public static void main(String args[]) {
        Shuffle s = new Shuffle();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int m = sc.nextInt();
            int[][] query = new int[m][2];
            for (int k = 0; k < query.length; k++) {
                query[k][0] = sc.nextInt();
                query[k][1] = sc.nextInt();
            }
            System.out.println(s.numberOfIndices(n, x, query));
        }
    }
}
