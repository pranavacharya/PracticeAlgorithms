package com.pranavacharya.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    class Node {

        int val;
        int max;

        public Node(int val, int max) {
            this.val = val;
            this.max = max;
        }

    }

    private Stack<Node> stack;

    public MaximumElement() {
        this.stack = new Stack();
    }

    public void addElement(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int highest = stack.peek().max;
            stack.push(new Node(val, Math.max(highest, val)));
        }
    }

    public void removeElement() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int getHighestElement() {
        return stack.peek().max;
    }

    public static void main(String args[]) {
        MaximumElement me = new MaximumElement();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int query = sc.nextInt();
            if (query == 1) {
                me.addElement(sc.nextInt());
            } else if (query == 2) {
                me.removeElement();
            } else {
                sb.append(me.getHighestElement()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
