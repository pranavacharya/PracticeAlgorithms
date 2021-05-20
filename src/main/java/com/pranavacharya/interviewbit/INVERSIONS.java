package com.pranavacharya.interviewbit;

import java.util.ArrayList;

public class INVERSIONS {

    public int countInversions(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        INVERSIONS iv = new INVERSIONS();
        ArrayList<Integer> A = new ArrayList();
        A.add(2);
        A.add(4);
        A.add(1);
        A.add(3);
        A.add(5);
        System.out.println(iv.countInversions(A));
    }
}
