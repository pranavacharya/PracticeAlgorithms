package com.pranavacharya.hackerrank;

import java.util.Arrays;

public class BubbleSort {

    static void countSwaps(int[] a) {
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    public static void main(String args[]) {
        int[] a = new int[]{3, 2, 1};
        countSwaps(a);
        System.out.println(Arrays.toString(a));
    }
}
