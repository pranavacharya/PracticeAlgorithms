package com.pranavacharya.kickstart;

import java.util.Scanner;

public class TrashBins {

    private long findDist(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                left[i + 1] = 0;
                last = i;
            } else {
                if (last == -1) {
                    left[i + 1] = Integer.MAX_VALUE;
                } else {
                    left[i + 1] = left[i] + 1;
                }
            }
        }
        last = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                right[i] = 0;
                last = i;
            } else {
                if (last == -1) {
                    right[i] = Integer.MAX_VALUE;
                } else {
                    right[i] = right[i + 1] + 1;
                }
            }
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        long max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.min(left[i + 1], right[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        TrashBins tb = new TrashBins();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            sb.append("Case #" + (i + 1) + ": " + tb.findDist(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
