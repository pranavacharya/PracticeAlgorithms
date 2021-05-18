package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NEXTGREATER {

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> res = new ArrayList();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res.add(-1);
            } else {
                res.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        NEXTGREATER ng = new NEXTGREATER();
        ArrayList<Integer> A = new ArrayList();
        A.add(4);
        A.add(5);
        A.add(2);
        A.add(10);
        System.out.println(ng.nextGreater(A));
    }
}
//4, 5, 2, 10
