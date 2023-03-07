package com.pranavacharya.hiringtest;

import java.util.ArrayList;
import java.util.List;

public class VaibhaviCongruent {

    private long findMin(List<Integer> arr) {
        long rs = 0;
        long x = Long.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            rs += arr.get(i);
            x = Math.min(x, rs);
        }
        if (x < 1) {
            return 1 - x;
        }
        return 0;
    }

    public static void main(String[] args) {
        VaibhaviCongruent vc = new VaibhaviCongruent();
//        int[] input = new int[]{0, 1};
        int[] input = new int[]{-5, 4, -2, 3, 1};
//        int[] input = new int[]{5, 4, -2, 3, 1};
//        int[] input = new int[]{-4, 3, 2, 1};
        List<Integer> listInput = new ArrayList();
        for (int i = 0; i < input.length; i++) {
            listInput.add(input[i]);
        }
        System.out.println(vc.findMin(listInput));
    }
}
