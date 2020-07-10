package com.pranavacharya.codechef;

import java.util.Scanner;

public class PPSUM {

    public int findSum(int d, int n) {
        while (d > 0) {
            n = (n * (n + 1)) / 2;
            d--;
        }
        return n;
    }

    public static void main(String args[]) {
        PPSUM p = new PPSUM();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int n = sc.nextInt();
            sb.append(p.findSum(d, n)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
