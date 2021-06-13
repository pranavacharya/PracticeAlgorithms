package com.pranavacharya.atcoder;

import java.util.Scanner;

public class PermutationCheck {

    private boolean isValid(int n, int[] nums) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n) {
                return false;
            }
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationCheck pc = new PermutationCheck();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(pc.isValid(n, nums) ? "Yes" : "No");
    }
}
