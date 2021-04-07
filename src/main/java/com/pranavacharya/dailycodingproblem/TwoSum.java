package com.pranavacharya.dailycodingproblem;

import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {

    private boolean isTwoSum(int[] arr, int k) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(k - arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(ts.isTwoSum(arr, k));
    }

}
