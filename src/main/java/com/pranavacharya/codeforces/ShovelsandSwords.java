package com.pranavacharya.codeforces;

import java.util.Scanner;

public class ShovelsandSwords {

    public void findCountEmerald(int i, int j) {
        int n = i + j;
        n = n / 3;
        System.out.println(Math.min(Math.min(i, j), n));
    }

    public static void main(String args[]) {
        ShovelsandSwords ss = new ShovelsandSwords();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            ss.findCountEmerald(j, k);
        }
    }
}
