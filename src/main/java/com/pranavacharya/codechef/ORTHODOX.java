package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ORTHODOX {

    public String isPossible(int n, long[] arr) {
        HashSet<Long> set = new HashSet();
        long[] cal = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    cal[j] = arr[j];
                } else {
                    cal[j] = cal[j - 1] | arr[j];
                }
                if (set.contains(cal[j])) {
                    return "NO";
                }
                set.add(cal[j]);
            }
        }
        System.out.println(Arrays.toString(cal));
        return "YES";
    }

    public static void main(String args[]) {
        ORTHODOX o = new ORTHODOX();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextLong();
            }
            sb.append(o.isPossible(n, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
