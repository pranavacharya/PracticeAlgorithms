package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ArraySumOperation {

    public List<Long> performOperations(int N, List<Integer> op) {
        List<Long> result = new ArrayList();
        Deque<Integer> dqueue = new LinkedList();
        HashSet<Integer> set = new HashSet();
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            dqueue.add(i);
            set.add(i);
            sum += i;
        }
        for (int i : op) {
            if (set.contains(i)) {
                int first = dqueue.pollFirst();
                int last = dqueue.pollLast();
                dqueue.addFirst(last);
                dqueue.addLast(first);
            } else {
                int last = dqueue.pollLast();
                sum -= last;
                set.remove(last);
                dqueue.addLast(i);
                set.add(i);
                sum += i;
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String args[]) {
        ArraySumOperation aso = new ArraySumOperation();
        List<Integer> op = new ArrayList();
        op.add(4);
        op.add(2);
        System.out.println(aso.performOperations(3, op));
    }
}
