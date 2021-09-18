package com.pranavacharya.kickstart;

import java.util.Scanner;

public class TrashBins {

    private int findDist(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            int local = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (arr[j] == '1') {
                    local = Math.min(local, Math.abs(j - i));
                }
            }
            min += local;
        }
        return min;
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
