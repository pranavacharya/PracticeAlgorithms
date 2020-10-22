package com.pranavacharya.codeforces;

import java.util.Scanner;

public class YetAnotherBookshelf {

    private int findNumberOfMoves(int[] arr) {
        int count = 0;
        int local = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count += local;
                local = 0;
                flag = true;
            } else if (flag) {
                local++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        YetAnotherBookshelf yabs = new YetAnotherBookshelf();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(yabs.findNumberOfMoves(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
