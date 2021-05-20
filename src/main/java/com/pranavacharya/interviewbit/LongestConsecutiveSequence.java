package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> set = new HashSet(A);
        int max = 0;
        for (int item : set) {
            if (set.contains(item - 1)) {
                continue;
            }
            int local = 1;
            while (set.contains(item + 1)) {
                item++;
                local++;
            }
            max = Math.max(max, local);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        List<Integer> A = new ArrayList();
        A.add(100);
        A.add(6);
        A.add(4);
        A.add(200);
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(5);
        System.out.println(lcs.longestConsecutive(A));
    }
}
//100, 4, 200, 1, 3, 2
