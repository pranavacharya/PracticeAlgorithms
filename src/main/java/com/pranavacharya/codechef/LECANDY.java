package com.pranavacharya.codechef;

import java.util.Scanner;

public class LECANDY {

    public String isPossible(int[] elephants, int candies) {
        for (int elephant : elephants) {
            candies -= elephant;
            if (candies < 0) {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String args[]) {
        LECANDY l = new LECANDY();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] elephants = new int[n];
            for (int j = 0; j < elephants.length; j++) {
                elephants[j] = sc.nextInt();
            }
            sb.append(l.isPossible(elephants, c)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
