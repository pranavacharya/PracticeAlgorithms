package com.pranavacharya.codechef;

import java.util.HashSet;
import java.util.Scanner;

public class CEQUAL {

    public String isPair(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String args[]) {
        CEQUAL c = new CEQUAL();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.isPair(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
