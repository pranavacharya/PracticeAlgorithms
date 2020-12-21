package com.pranavacharya.codechef;

import java.util.Scanner;

public class ATTENDU {

    public String canPass(String s) {
        double count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {

            if (s.charAt(i) == '1') {
                count++;
            }
        }
        double percent = (count + (120 - s.length())) / 120.0 * 100.0;
        if (percent < 75) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String args[]) {
        ATTENDU a = new ATTENDU();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String attendence = sc.next();
            sb.append(a.canPass(attendence)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
