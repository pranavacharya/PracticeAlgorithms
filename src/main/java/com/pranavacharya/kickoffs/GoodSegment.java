package com.pranavacharya.kickoffs;

import java.util.ArrayList;
import java.util.List;

public class GoodSegment {

    public int goodSegment(List<Integer> badNumbers, int lower, int upper) {
        int max = 0;
        int count = 0;
        for (int i = lower; i <= upper; i++) {
            if (!badNumbers.contains(i)) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        GoodSegment gs = new GoodSegment();
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
