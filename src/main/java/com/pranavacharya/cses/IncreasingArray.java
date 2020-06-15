package com.pranavacharya.cses;

import java.util.Scanner;

public class IncreasingArray {

    public long minTurn(int[] arr) {
        long count = 0;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < last) {
                count = count + (last - arr[i]);
            } else {
                last = arr[i];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        IncreasingArray ia = new IncreasingArray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(ia.minTurn(arr));
    }
}
