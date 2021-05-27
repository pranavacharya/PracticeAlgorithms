package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinJumpsArray {

    public int jump(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList();
        int lastAdded = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == A.size() - 1) {
                return curr[1];
            }
            int start = Math.max(curr[0], lastAdded);
            int end = Math.min(A.size() - 1, curr[0] + A.get(curr[0]));
            for (int i = start + 1; i <= end; i++) {
                queue.add(new int[]{i, curr[1] + 1});
                lastAdded = i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinJumpsArray mja = new MinJumpsArray();
        ArrayList<Integer> A = new ArrayList();
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(1);
        A.add(4);
        System.out.println(mja.jump(A));
    }
}
