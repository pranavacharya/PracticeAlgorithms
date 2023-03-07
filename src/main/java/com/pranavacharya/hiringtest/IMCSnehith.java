package com.pranavacharya.hiringtest;

import java.util.PriorityQueue;

public class IMCSnehith {

    private int[] getResult(int[] arrival, int[] street) {
        int[] result = new int[arrival.length];
        int lastPass = -1;
        int lastPassTime = -2;
        int time = 0;
        PriorityQueue<int[]> street1 = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<int[]> street2 = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < arrival.length; i++) {
            if (street[i] == 0) {
                street1.add(new int[]{arrival[i], i});
            } else {
                street2.add(new int[]{arrival[i], i});
            }
        }

        while (!street1.isEmpty() && !street2.isEmpty()) {
            int[] one = street1.peek();
            int[] two = street2.peek();
            if (one[0] < two[0]) {

            } else {

            }
            if (lastPassTime == time - 1) {

            } else {

            }
        }
        return result;
    }
}
