package com.pranavacharya.atcoder;

import java.util.Scanner;

public class POW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b) {
            System.out.println("=");
        } else if (a > 0 && b > 0) {
            System.out.println(a > b ? ">" : "<");
        } else if (a < 0 && b < 0) {
            if (c % 2 == 0) {
                System.out.println(Math.abs(a) > Math.abs(b) ? ">" : "<");
            } else {
                System.out.println(Math.abs(a) < Math.abs(b) ? ">" : "<");
            }
        } else {
            if (Math.abs(a) == Math.abs(b) && c % 2 == 0) {
                System.out.println("=");
            } else if (c % 2 == 0) {
                System.out.println(Math.abs(a) > Math.abs(b) ? ">" : "<");
            } else {
                System.out.println(a > b ? ">" : "<");
            }
        }
    }
}
