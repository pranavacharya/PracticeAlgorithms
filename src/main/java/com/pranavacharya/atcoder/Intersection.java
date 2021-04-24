package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Intersection {

    private int findIntersections(int[] a, int[] b) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            min = Math.min(min, b[i]);
        }

        if (max > min) {
            return 0;
        } else {
            return min - max + 1;
        }
    }

    public static void main(String[] args) {
        Intersection i = new Intersection();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            b[j] = sc.nextInt();
        }
        System.out.println(i.findIntersections(a, b));
    }
}
