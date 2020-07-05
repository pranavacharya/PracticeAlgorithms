package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Payment {

    public int findChange(int amount) {
        int n = 0;
        while (n < amount) {
            n = n + 1000;
        }
        return n - amount;
    }

    public static void main(String args[]) {
        Payment p = new Payment();
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        System.out.println(p.findChange(amount));
    }
}
