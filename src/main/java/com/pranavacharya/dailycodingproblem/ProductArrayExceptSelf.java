package com.pranavacharya.dailycodingproblem;

import java.util.Arrays;
import java.util.Scanner;

public class ProductArrayExceptSelf {

    private int[] calProduct(int arr[]) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        prefix[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = arr[i - 1] * prefix[i - 1];
        }
        suffix[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = arr[i] * suffix[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * suffix[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelf paes = new ProductArrayExceptSelf();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(paes.calProduct(arr)));
    }
}
