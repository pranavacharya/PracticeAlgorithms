package com.pranavacharya.atcoder;

import java.util.Scanner;

public class SquareInequality {

    private boolean isValid(int a, int b, int c) {
        return (Math.pow(a, 2) + Math.pow(b, 2)) < Math.pow(c, 2);
    }

    public static void main(String[] args) {
        SquareInequality si = new SquareInequality();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (si.isValid(a, b, c)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
