package com.pranavacharya.codechef;

import java.util.Scanner;

public class POSAND {

    public int[] findPermutation(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        if (isPowerOfTwo(n)) {
            return new int[]{-1};
        }
        int[] arr = new int[n];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            if (isPowerOfTwo(i + 1)) {
                arr[i] = i + 2;
                arr[i + 1] = i + 1;
                i++;
            } else {
                arr[i] = i + 1;
            }
        }
        return arr;
    }

    private boolean isPowerOfTwo(int n) {
        return (int) (Math.ceil((Math.log(n) / Math.log(2))))
                == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
    }

    public static void main(String args[]) {
        POSAND p = new POSAND();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = p.findPermutation(n);
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
