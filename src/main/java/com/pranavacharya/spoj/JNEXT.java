package com.pranavacharya.spoj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class JNEXT {

    public String findjNext(Stack<Integer> stack) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int last = stack.pop();
        while (!stack.isEmpty() && stack.peek() >= last) {
            queue.add(last);
            last = stack.pop();
        }
        if (stack.isEmpty()) {
            return "-1";
        } else {
            int swapdigit = stack.pop();
            queue.add(swapdigit);
            queue.add(last);
            ArrayList<Integer> temp = new ArrayList();
            while (!queue.isEmpty() && queue.peek() <= swapdigit) {
                temp.add(queue.poll());
            }
            if (queue.isEmpty()) {
                return "-1";
            }
            stack.add(queue.poll());
            queue.addAll(temp);
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb = sb.reverse();
            while (!queue.isEmpty()) {
                sb.append(queue.poll());
            }
            return sb.toString();
        }
    }

    public static void main(String args[]) {
        JNEXT jn = new JNEXT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Stack<Integer> num = new Stack();
            for (int j = 0; j < n; j++) {
                num.push(sc.nextInt());
            }
            sb.append(jn.findjNext(num)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
