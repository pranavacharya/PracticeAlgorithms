package com.pranavacharya.ds;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class StackNode<T> {

        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }

    }

    private StackNode<T> top;

    public T peek() {
        return top.data;
    }

    public void push(T item) {
        StackNode<T> temp = new StackNode<T>(item);
        temp.next = top;
        top = temp;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        StackNode<T> popElement = top;
        top = top.next;
        return popElement.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
