package com.pranavacharya.cses;

import java.util.Scanner;

public class Repetitions {

    public int maxRep(String ip) {
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < ip.length()) {
            while (j < ip.length() && ip.charAt(i) == ip.charAt(j)) {
                j++;
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }

    public static void main(String args[]) {
        Repetitions r = new Repetitions();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(r.maxRep(input));
    }
}
