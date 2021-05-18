package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementintheArray {

    public int kthsmallest(final List<Integer> A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < A.size(); i++) {
            maxHeap.add(A.get(i));
            if (maxHeap.size() > B) {
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        KthSmallestElementintheArray kmeia = new KthSmallestElementintheArray();
        List<Integer> A = new ArrayList();
        A.add(2);
        A.add(1);
        A.add(4);
        A.add(3);
        A.add(2);
        System.out.println(kmeia.kthsmallest(A, 3));
    }
}
