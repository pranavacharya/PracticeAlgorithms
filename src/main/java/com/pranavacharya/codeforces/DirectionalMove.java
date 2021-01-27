package com.pranavacharya.codeforces;

import java.util.Scanner;

public class DirectionalMove {

    private char findDirection(String s) {
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                right++;
            } else {
                right--;
            }
        }
        if (right == 0) {
            return 'E';
        } else if (right > 0) {
            if (right % 4 == 0) {
                return 'E';
            } else if (right % 4 == 1) {
                return 'S';
            } else if (right % 4 == 2) {
                return 'W';
            } else {
                return 'N';
            }
        } else {
            right = right * -1;
            if (right % 4 == 0) {
                return 'E';
            } else if (right % 4 == 1) {
                return 'N';
            } else if (right % 4 == 2) {
                return 'W';
            } else {
                return 'S';
            }
        }
    }

    public static void main(String args[]) {
        DirectionalMove dm = new DirectionalMove();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            sb.append(dm.findDirection(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
