package com.pranavacharya.codeforces;

import java.util.Scanner;

public class TMTDocument {

    private boolean isTMTDoc(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return helper(s) && helper(sb.toString());
    }

    private boolean helper(String s) {
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T') {
                t++;
            } else {
                t--;
            }
            if (t < 0) {
                return false;
            }
        }
        return s.length() == 3 * t;
    }

    public static void main(String[] args) {
        TMTDocument td = new TMTDocument();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            if (td.isTMTDoc(s)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
