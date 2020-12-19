package com.pranavacharya.codechef;

import java.util.Scanner;

public class HXOR {

    private int highestPowerof2(int n) {
        int p = (int) (Math.log(n)
                / Math.log(2));
        return (int) Math.pow(2, p);
    }

    public int[] findSmallestSequence(int[] arr, int x) {
        int n = arr.length;
        int i = 0;
        while (true) {
            if (x == 0) {
                break;
            }
            while (i < n && arr[i] == 0) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            int gpot = highestPowerof2(arr[i]);
            arr[i] = arr[i] ^ gpot;
            int j = i + 1;
            while (true) {
                if (j == n - 1) {
                    arr[j] = arr[j] ^ gpot;
                    break;
                }
                if (arr[j] > (arr[j] ^ gpot)) {
                    arr[j] = arr[j] ^ gpot;
                    break;
                }
                j++;
            }
            x--;
        }

        if (x == 1 || (x % 2 != 0 && n == 2)) {
            arr[n - 2] = arr[n - 2] ^ 1;
            arr[n - 1] = arr[n - 1] ^ 1;
        }
        return arr;
    }

    public static void main(String args[]) {
        HXOR h = new HXOR();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[] res = h.findSmallestSequence(arr, x);
            for (int j = 0; j < res.length; j++) {
                sb.append(res[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
