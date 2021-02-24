/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pranavacharya.codechef;

import java.util.Scanner;

/**
 *
 * @author pranav
 */
public class BMI {

    private int findBmi(int m, int h) {
        h = h * h;
        double bmi = (double) m / (double) h;
        if (bmi <= 18) {
            return 1;
        } else if (bmi <= 24) {
            return 2;
        } else if (bmi <= 29) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String args[]) {
        BMI b = new BMI();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int h = sc.nextInt();
            sb.append(b.findBmi(m, h)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
