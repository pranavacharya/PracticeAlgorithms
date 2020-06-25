package com.pranavacharya.codechef;

import java.util.HashSet;
import java.util.Scanner;

public class MAXMEX {

    public int findLenght(int m, int[] arr) {
        HashSet<Integer> set = new HashSet();
        int count = 0;
        int mex = 1;
        for (int a : arr) {
            if (a == m) {
                continue;
            }
            count++;
            set.add(a);
            while (set.contains(mex)) {
                mex++;
            }
        }
        if (mex == m) {
            return count;
        } else {
            return - 1;
        }
    }

    public static void main(String args[]) {
        MAXMEX mm = new MAXMEX();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(mm.findLenght(m, arr));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
