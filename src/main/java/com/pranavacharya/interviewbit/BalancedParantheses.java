package com.pranavacharya.interviewbit;

import java.util.Stack;

public class BalancedParantheses {

    public int solve(String A) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (stack.isEmpty()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    return 0;
                }
            } else {
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        BalancedParantheses bp = new BalancedParantheses();
        System.out.println(bp.solve("(()())"));
    }
}
