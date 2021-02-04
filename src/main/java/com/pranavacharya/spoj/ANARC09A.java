package com.pranavacharya.spoj;

import java.util.Scanner;
import java.util.Stack;

public class ANARC09A {

    private int minOps(String s) {
        int ops = 0;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    ops++;
                    stack.push('{');
                } else if (stack.peek() == '{') {
                    stack.pop();
                }
            }
        }
        ops += stack.size() / 2;
        return ops;
    }

    public static void main(String args[]) {
        ANARC09A a = new ANARC09A();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while (true) {
            String s = sc.next();
            if (s.charAt(0) == '-') {
                break;
            }
            sb.append(testCase).append(". ").append(a.minOps(s)).append("\n");
            testCase++;
        }
        System.out.println(sb.toString());
    }
}
