package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ArraySumOperation {

    public List<Long> performOperations(int N, List<Integer> op) {
        List<Long> result = new ArrayList();
        long n = N;
        long sum = ((n * (n + 1)) / 2);
        int first = 1;
        int last = N;
        for (int i : op) {
            if (i == first || i == last || (i > 1 && i < N)) {
                int temp = last;
                last = first;
                first = temp;
            } else {
                sum -= last;
                sum += i;
                last = i;
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
