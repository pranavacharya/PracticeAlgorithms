package com.pranavacharya.codechef;

import java.util.Scanner;

public class TWOVSTEN {

    public int findMin(int n) {
        if (n % 5 != 0) {
            return -1;
        } else {
            if (n % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main(String args[]) {
        TWOVSTEN tvt = new TWOVSTEN();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(tvt.findMin(n)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
