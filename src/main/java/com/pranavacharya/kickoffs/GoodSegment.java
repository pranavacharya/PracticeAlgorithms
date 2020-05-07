package com.pranavacharya.kickoffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodSegment {

    public int goodSegment(List<Integer> badNumbers, int lower, int upper) {
        int max = 0;
        int local = 0;
        Collections.sort(badNumbers);
        for (int badNumber : badNumbers) {
            if (badNumber >= upper) {
                break;
            }
            if (badNumber >= lower) {
                local = badNumber - lower;
                lower = badNumber + 1;
                max = Math.max(max, local);
            }
        }
        if (lower != upper) {
            local = upper - lower + 1;
            max = Math.max(max, local);
        }
        return max;
    }

    public static void main(String args[]) {
        GoodSegment gs = new GoodSegment();
//        List<Integer> badNumbers = new ArrayList();
//        badNumbers.add(5);
//        badNumbers.add(4);
//        badNumbers.add(2);
//        badNumbers.add(15);
//        System.out.println(gs.goodSegment(badNumbers, 1, 10));
        List<Integer> badNumbers = new ArrayList();
        badNumbers.add(37);
        badNumbers.add(7);
        badNumbers.add(22);
        badNumbers.add(15);
        badNumbers.add(49);
        badNumbers.add(60);
        System.out.println(gs.goodSegment(badNumbers, 3, 48));
    }
}
