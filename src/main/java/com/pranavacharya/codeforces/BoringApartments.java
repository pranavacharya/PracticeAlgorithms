package com.pranavacharya.codeforces;

import java.util.Scanner;

public class BoringApartments {

    public int countDigits(int n) {
        int unit = n % 10;
        int count = 10 * (unit - 1);
        int digits = 0;
        while (n > 0) {
            n = n / 10;
            digits++;
        }
        return count + (digits * (digits + 1) / 2);
    }

    public static void main(String args[]) {
        BoringApartments ba = new BoringApartments();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int number = sc.nextInt();
            sb.append(ba.countDigits(number)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
