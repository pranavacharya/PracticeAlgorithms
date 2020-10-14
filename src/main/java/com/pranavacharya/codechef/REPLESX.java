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
        if (k == p) {
            if (x < arr[k]) {
                return numberOfElementsGreaterThanX(arr, p, x);
            } else {
                return numberOfElementsLessThanX(arr, p, x);
            }

        } else if (k > p) {
            if (x < arr[k] && x < arr[p]) {
                return numberOfElementsGreaterThanX(arr, p, x);
            } else {
                return -1;
            }
        } else {
            if (x > arr[k] && x > arr[p]) {
                return numberOfElementsLessThanX(arr, p, x);
            } else {
                return -1;
            }
        }
    }

    private int numberOfElementsGreaterThanX(int a[], int pos, int x) {
        int ans = 0;
        for (int i = pos; i >= 0; i--) {
            if (a[i] > x) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    private int numberOfElementsLessThanX(int a[], int pos, int x) {
        int ans = 0;
        for (int i = pos; i < a.length; i++) {
            if (a[i] < x) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
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
