package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {

    public long countTriplets(List<Long> arr, long r) {
        long count = 0;
        HashMap<Long, Long> left = new HashMap();
        HashMap<Long, Long> right = new HashMap();
        for (long num : arr) {
            right.put(num, right.getOrDefault(num, 0l) + 1);
        }

        for (long num : arr) {
            right.put(num, right.getOrDefault(num, 0l) - 1);
            if (num % r == 0) {
                long leftCount = left.getOrDefault(num / r, 0l);
                long rightCount = right.getOrDefault(num * r, 0l);
                count += (leftCount * rightCount);
            }
            left.put(num, left.getOrDefault(num, 0l) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        CountTriplets ct = new CountTriplets();
        List<Long> arr = new ArrayList();
        arr.add(1l);
        arr.add(2l);
        arr.add(1l);
        arr.add(2l);
        arr.add(4l);
        System.out.println(ct.countTriplets(arr, 2));
    }
}
