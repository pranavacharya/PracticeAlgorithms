package com.pranavacharya.codeforces;

import java.util.Scanner;

public class XORGame {

    public String isPossible(int a, int b) {
        int xor = a ^ b;
        if (setBits(xor) == setBits(a) + setBits(b)) {
            return "No";
        } else {
            return "Yes";
        }
    }

    private int setBits(int a) {
        int lenght = (int) (Math.log(a)
                / Math.log(2) + 1);
        int mask = 1;
        int count = 0;
        for (int i = 0; i < lenght; i++, mask <<= 1) {
            if ((a & mask) == mask) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        XORGame xg = new XORGame();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(xg.isPossible(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
