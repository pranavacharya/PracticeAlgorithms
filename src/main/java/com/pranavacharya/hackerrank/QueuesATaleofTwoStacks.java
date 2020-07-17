package com.pranavacharya.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class QueuesATaleofTwoStacks {

    public static class MyQueue<Integer> {

        private Stack<Integer> stackMain;
        private Stack<Integer> stackSecond;

        public MyQueue() {
            this.stackMain = new Stack();
            this.stackSecond = new Stack();
        }

        public void enqueue(Integer val) {
            this.stackMain.push(val);
        }

        public Integer dequeue() {
            if (stackSecond.isEmpty()) {
                transfer(stackMain, stackSecond);
            }
            return stackSecond.pop();
        }

        public Integer peek() {
            if (stackSecond.isEmpty()) {
                transfer(stackMain, stackSecond);
            }
            return stackSecond.peek();
        }

        private void transfer(Stack s1, Stack s2) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
