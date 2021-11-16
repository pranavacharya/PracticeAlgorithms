package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHEAPFUEL {

    private String comparePrice(int x, int y, int a, int b, int k) {
        long px = x + a * k;
        long py = y + b * k;
        if (px == py) {
            return "SAME PRICE";
        } else if (px < py) {
            return "PETROL";
        } else {
            return "DIESEL";
        }
    }

    public static void main(String[] args) {
        CHEAPFUEL cf = new CHEAPFUEL();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            sb.append(cf.comparePrice(x, y, a, b, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
