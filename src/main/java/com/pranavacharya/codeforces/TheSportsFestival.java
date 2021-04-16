package com.pranavacharya.codeforces;

import java.util.Scanner;

public class TheSportsFestival {

    private long minDiff = Long.MAX_VALUE;

    private long findMinPosDiff(long[] arr) {
        int n = arr.length;
        permute(arr, new boolean[n], 0, 0, Long.MAX_VALUE, Long.MIN_VALUE);
        return this.minDiff;
    }

    private void permute(long[] arr, boolean[] visited, int index, long diff, long min, long max) {
        if (index == arr.length) {
            this.minDiff = Math.min(this.minDiff, diff);
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            long localDiff = Math.max(max, arr[i]) - Math.min(min, arr[i]);
            permute(arr, visited, index + 1, diff + localDiff, Math.min(min, arr[i]), Math.max(max, arr[i]));
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        TheSportsFestival sp = new TheSportsFestival();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(sp.findMinPosDiff(arr));
    }
}
