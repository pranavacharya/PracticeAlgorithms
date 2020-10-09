package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrictlyIncreasingSequence {

    public static String whoIsTheWinner(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int normalElement = 0;
        int duplicate = 0;
        for (int val : map.values()) {
            if (val == 1) {
                normalElement++;
            } else {
                duplicate = val - 1;
            }
        }
        if (normalElement == arr.size()) {
            return "First";
        }
        if (normalElement % 2 == 0) {
            if (duplicate % 2 == 0) {
                return "First";
            } else {
                return "Second";
            }
        } else {
            if (duplicate % 2 != 0) {
                return "First";
            } else {
                return "Second";
            }
        }
    }

    public static void main(String args[]) {
        List<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(5);
        System.out.println(whoIsTheWinner(arr));
    }
}
