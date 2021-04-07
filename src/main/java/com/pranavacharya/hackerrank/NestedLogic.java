package com.pranavacharya.hackerrank;

import java.util.Scanner;

public class NestedLogic {

    private int calFine(String date, String due) {
        String[] rdate = date.split(" ");
        String[] ddate = due.split(" ");
        if (Integer.parseInt(ddate[2]) == Integer.parseInt(rdate[2])) {
            if (Integer.parseInt(ddate[1]) == Integer.parseInt(rdate[1])) {
                if (Integer.parseInt(ddate[0]) >= Integer.parseInt(rdate[0])) {
                    return 0;
                } else {
                    return (Integer.parseInt(rdate[0]) - Integer.parseInt(ddate[0])) * 15;
                }
            } else if (Integer.parseInt(ddate[1]) > Integer.parseInt(rdate[1])) {
                return 0;
            } else {
                return (Integer.parseInt(rdate[1]) - Integer.parseInt(ddate[1])) * 500;
            }
        } else if (Integer.parseInt(ddate[2]) > Integer.parseInt(rdate[2])) {
            return 0;
        } else {
            return 10000;
        }
    }

    public static void main(String[] args) {
        NestedLogic nl = new NestedLogic();
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        String due = sc.nextLine();
        System.out.println(nl.calFine(date, due));
    }
}
