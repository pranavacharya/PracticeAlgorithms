package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Kcal {

    public static void main(String[] args) {
        Kcal kc = new Kcal();
        Scanner sc = new Scanner(System.in);
        double per100 = sc.nextInt();
        double req = sc.nextInt();
        System.out.println(req / 100.0 * per100);
    }
}
