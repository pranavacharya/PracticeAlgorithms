package com.pranavacharya.interviewbit;

import java.util.ArrayList;

public class Bulbs {

    public int bulbs(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (count % 2 == 0) {
                if (A.get(i) == 0) {
                    count++;
                }
            } else {
                if (A.get(i) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Bulbs bulb = new Bulbs();
        ArrayList<Integer> A = new ArrayList();
        A.add(0);
        A.add(1);
        A.add(0);
        A.add(1);
        System.out.println(bulb.bulbs(A));
    }
}
