package com.pranavacharya.codechef;

import java.util.Scanner;

public class SPLST {

    public String canSplit(int a, int b, int c, int x, int y) {
        boolean status = false;
        status = isPossible(a, b, c, x, y);
        status = status || isPossible(b, c, a, x, y);
        status = status || isPossible(c, a, b, x, y);
        if (status) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private boolean isPossible(int a, int b, int c, int x, int y) {
        if ((x - b >= 0 && y - c >= 0 && (x - b + y - c == a) || (y - b >= 0 && x - c >= 0 && (y - b + x - c == a)))) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        SPLST s = new SPLST();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            sb.append(s.canSplit(a, b, c, x, y)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
