package com.pranavacharya.codechef;

import java.util.Scanner;

public class CPAIRS {

    public int findNumberOfPairs(int[] arr) {
        int oddCount = 0;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                count += oddCount;
            } else {
                oddCount++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CPAIRS c = new CPAIRS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.findNumberOfPairs(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
