package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {

    public int candy(ArrayList<Integer> A) {
        int[] pref = new int[A.size()];
        int[] suff = new int[A.size()];
        Arrays.fill(pref, 1);
        Arrays.fill(suff, 1);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                pref[i] = pref[i - 1] + 1;
            }
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                suff[i] = suff[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < pref.length; i++) {
            count += Math.max(pref[i], suff[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        DistributeCandy dc = new DistributeCandy();
        ArrayList<Integer> A = new ArrayList();
        A.add(1);
        A.add(5);
        A.add(2);
        A.add(1);
        System.out.println(dc.candy(A));
    }
}
