package com.pranavacharya.cses;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {

    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int low = 1;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mn.missingNumber(arr));
    }
}
