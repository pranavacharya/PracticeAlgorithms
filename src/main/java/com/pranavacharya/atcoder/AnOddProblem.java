package com.pranavacharya.atcoder;

import java.util.Scanner;

public class AnOddProblem {

    public int countValidSquare(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 != 0 && arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        AnOddProblem aop = new AnOddProblem();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(aop.countValidSquare(arr));
    }
}
