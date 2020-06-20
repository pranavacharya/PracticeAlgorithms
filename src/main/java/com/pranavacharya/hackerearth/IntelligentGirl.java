package com.pranavacharya.hackerearth;

import java.util.Scanner;

public class IntelligentGirl {

    public void findEven(String ip) {
        int even = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = ip.length() - 1; i >= 0; i--) {
            if ((ip.charAt(i) - '0') % 2 == 0) {
                even++;
            }
            sb.insert(0, even + " ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String args[]) {
        IntelligentGirl ig = new IntelligentGirl();
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        ig.findEven(ip);
    }
}
