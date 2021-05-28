package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
            if (minHeap.size() > B) {
                minHeap.poll();
            }
        }
        ArrayList<Integer> ans = new ArrayList(minHeap);
        return ans;
    }

    public static void main(String[] args) {
        KLargestElements kle = new KLargestElements();
        ArrayList<Integer> A = new ArrayList();
        A.add(11);
        A.add(3);
        A.add(4);
        A.add(6);
        System.out.println(kle.solve(A, 3));
    }
}
