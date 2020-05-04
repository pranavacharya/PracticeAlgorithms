package com.pranavacharya.codechef;

import java.util.Scanner;

public class Covid19 {

    public void spreadMeasure(int[] distance) {
        int max = 1;
        int min = distance.length;
        int i = 0;
        int j;
        for (j = 1; j < distance.length; j++) {
            if (Math.abs(distance[j] - distance[j - 1]) <= 2) {
                max = Math.max(max, j - i + 1);
            } else {
                min = Math.min(min, j - i);
                i = j;
            }
        }
        if (i != j) {
            max = Math.max(max, j - i);
            min = Math.min(min, j - i);
        }
        System.out.format("%d %d", min, max);
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Covid19 covid = new Covid19();
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int len = sc.nextInt();
            int[] distance = new int[len];
            for (int j = 0; j < len; j++) {
                distance[j] = sc.nextInt();
            }
            covid.spreadMeasure(distance);
        }
    }
}
