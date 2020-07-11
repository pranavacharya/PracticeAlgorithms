package com.pranavacharya.atcoder;

import java.util.Scanner;

public class NumberofMultiples {

    public int countMultiple(int l, int r, int d) {
        int ans = (r / d) - (l / d);
        return l % d == 0 ? ans + 1 : ans;
    }

    public static void main(String args[]) {
        NumberofMultiples nm = new NumberofMultiples();
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(nm.countMultiple(l, r, d));
    }
}
