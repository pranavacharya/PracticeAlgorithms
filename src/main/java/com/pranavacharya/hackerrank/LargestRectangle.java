package com.pranavacharya.hackerrank;

import java.util.Stack;

public class LargestRectangle {

    public long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack();
        long maxArea = 0;
        int i = 0;
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
            } else {
                while (h[stack.peek()] > h[i]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        maxArea = Math.max(maxArea, i * h[top]);
                        break;
                    } else {
                        maxArea = Math.max(maxArea, (i - stack.peek() - 1) * h[top]);
                    }
                }
                stack.push(i);
            }
            i++;
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, i * h[top]);
            } else {
                maxArea = Math.max(maxArea, (i - stack.peek() - 1) * h[top]);
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        LargestRectangle lr = new LargestRectangle();
        int[] h = new int[]{1, 2, 3, 4, 5};
        System.out.println(lr.largestRectangle(h));
    }
}
