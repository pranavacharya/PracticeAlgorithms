package com.pranavacharya.codechef;

import java.util.Scanner;

public class VACCINE1 {

    public int findMinDay(int d1, int v1, int d2, int v2, int p) {
        int index = 1;
        while (true) {
            if (index >= d1) {
                p -= v1;
            }
            if (index >= d2) {
                p -= v2;
            }
            if (p <= 0) {
                return index;
            }
            index++;
        }
    }

    public static void main(String args[]) {
        VACCINE1 v = new VACCINE1();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int d1 = sc.nextInt();
        int v1 = sc.nextInt();
        int d2 = sc.nextInt();
        int v2 = sc.nextInt();
        int p = sc.nextInt();
        sb.append(v.findMinDay(d1, v1, d2, v2, p));
        System.out.println(sb.toString());
    }
}
