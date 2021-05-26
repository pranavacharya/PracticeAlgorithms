package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int low = -1;
        int high = -1;
        map.put(sum, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int localLow = map.get(sum);
                int localHigh = i;
                if (localHigh - localLow > high - low) {
                    low = localLow;
                    high = localHigh;
                }
            } else {
                map.put(sum, i);
            }
        }
        ArrayList<Integer> ans = new ArrayList();
        for (int i = low + 1; i <= high; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum lcsz = new LargestContinuousSequenceZeroSum();
        ArrayList<Integer> A = new ArrayList();
        A.add(1);
        A.add(2);
        A.add(-3);
        A.add(3);
//        A.add(-4);
        System.out.println(lcsz.lszero(A));
    }
}

//1, 2, -3, 3
