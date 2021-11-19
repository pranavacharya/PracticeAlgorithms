package com.pranavacharya.hackerrank;

import java.util.List;

public class FindFirstMissingGuest {

    public static int findMissing(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

}
