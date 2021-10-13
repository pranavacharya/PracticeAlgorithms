package com.pranavacharya.hackerrank;

import java.util.List;

public class TaskOfPairing {

    public static long taskOfPairing(List<Long> freq) {
        // Write your code here
        long max = freq.get(0);
        int max_index = 0;
        for (int i = 1; i < freq.size(); i++) {
            if (max < freq.get(i)) {
                max = freq.get(i);
                max_index = i;
            }
        }
        long pairs = 0;
        for (int i = 0; i < max_index; i++) {
            long count = freq.get(i);
            pairs += count / 2;
            count %= 2;
            long next_count = freq.get(i + 1);
            pairs += Math.min(count, next_count);
            if (next_count > count) {
                freq.set(i + 1, next_count - count);
            } else {
                freq.set(i + 1, 0l);
            }
        }

        for (int i = freq.size() - 1; i > max_index; i--) {
            long count = freq.get(i);
            pairs += count / 2;
            count %= 2;
            long next_count = freq.get(i - 1);
            pairs += Math.min(count, next_count);
            if (next_count > count) {
                freq.set(i - 1, next_count - count);
            } else {
                freq.set(i - 1, 0L);
            }
        }
        pairs += freq.get(max_index) / 2;
        return pairs;
    }
}
