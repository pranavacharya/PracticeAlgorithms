package com.pranavacharya.codeforces;

import java.util.Scanner;

public class KefaandFirstSteps {

    private int findMaxNonDecreasingSequence(int[] arr) {
        int max = 0;
        int index = 0;
        while (index < arr.length) {
            int local = 1;
            while (index + 1 < arr.length) {
                if (arr[index + 1] >= arr[index]) {
                    index++;
                    local++;
                } else {
                    break;
                }
            }
            max = Math.max(max, local);
            index++;
        }
        return max;
    }

    public static void main(String args[]) {
        KefaandFirstSteps kfs = new KefaandFirstSteps();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(kfs.findMaxNonDecreasingSequence(arr));
    }
}
