package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<int[]> stack1 = new Stack();
        Stack<int[]> stack2 = new Stack();
        Stack<int[]> stack3 = new Stack();
        int sum = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            sum += h1.get(i);
            stack1.push(new int[]{h1.get(i), sum});
        }
        sum = 0;
        for (int i = h2.size() - 1; i >= 0; i--) {
            sum += h2.get(i);
            stack2.push(new int[]{h2.get(i), sum});
        }
        sum = 0;
        for (int i = h3.size() - 1; i >= 0; i--) {
            sum += h3.get(i);
            stack3.push(new int[]{h3.get(i), sum});
        }
        if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
            return 0;
        }
        while (stack1.peek()[1] != stack2.peek()[1] || stack2.peek()[1] != stack3.peek()[1]) {
            if (stack1.peek()[1] > stack2.peek()[1]) {
                if (stack3.peek()[1] > stack1.peek()[1]) {
                    if (!stack3.isEmpty()) {
                        stack3.pop();
                    } else {
                        return 0;
                    }
                } else if (stack3.peek()[1] <= stack1.peek()[1]) {
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    } else {
                        return 0;
                    }
                }
            } else if (stack1.peek()[1] <= stack2.peek()[1]) {
                if (stack3.peek()[1] > stack2.peek()[1]) {
                    if (!stack3.isEmpty()) {
                        stack3.pop();
                    } else {
                        return 0;
                    }
                } else if (stack3.peek()[1] <= stack2.peek()[1]) {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    } else {
                        return 0;
                    }
                }
            }
            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                return 0;
            }
        }
        if (stack1.isEmpty()) {
            return 0;
        }
        return stack1.peek()[1];
    }

    public static void main(String args[]) {
        List<Integer> h1 = new ArrayList();
        List<Integer> h2 = new ArrayList();
        List<Integer> h3 = new ArrayList();
        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);
        h2.add(4);
        h2.add(3);
        h2.add(2);
        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);
        System.out.println(equalStacks(h1, h2, h3));
    }
}
