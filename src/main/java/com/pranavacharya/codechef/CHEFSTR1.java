package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHEFSTR1 {

    public long findSkiped(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        long skipped = 0;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            skipped = skipped + Math.abs(arr[i] - last) - 1;
            last = arr[i];
        }
        return skipped;
    }

    public static void main(String args[]) {
        CHEFSTR1 c = new CHEFSTR1();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.findSkiped(arr)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
