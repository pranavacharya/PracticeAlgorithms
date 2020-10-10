package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class REPLESX {

    public int findMinOps(int[] arr, int x, int k, int p) {
        k--;
        p--;
        Arrays.sort(arr);
        if (arr[p] == x) {
            return 0;
        }
        boolean hasTarget = hasTarget(arr, x) != -1;
        if (k == p) {
            if (x == arr[k]) {
                return 0;
            } else {
                if (hasTarget) {
                    return Math.abs(findPos(arr, x) - k);
                } else {
                    return Math.abs(findPos(arr, x) - k) + 1;
                }
            }
        } else if (k > p) {
            if (x < arr[k] && x < arr[p]) {
                if (hasTarget) {
                    return p - findPos(arr, x);
                } else {
                    return p - findPos(arr, x) + 1;
                }
            } else {
                return -1;
            }
        } else {
            if (x > arr[k] && x > arr[p]) {
                if (hasTarget) {
                    return findPos(arr, x) - p;
                } else {
                    return findPos(arr, x) - p + 1;
                }
            } else {
                return -1;
            }
        }
    }

    private int hasTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findPos(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        REPLESX r = new REPLESX();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int p = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(r.findMinOps(arr, x, k, p)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
