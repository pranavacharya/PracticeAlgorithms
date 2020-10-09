package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class GameofMaximization {

    public static int maximumStones(List<Integer> arr) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((i + 1) % 2 == 0) {
                even += arr.get(i);
            } else {
                odd += arr.get(i);
            }
        }
        return 2 * Math.min(odd, even);
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList();
        System.out.println(maximumStones(list));
    }
}
