package com.pranavacharya.ds;

import java.util.NoSuchElementException;

public class Queue<T> {

    private static class QueueNode<T> {

        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }

    }

    private QueueNode<T> front;
    private QueueNode<T> end;

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public void add(T item) {
        QueueNode<T> temp = new QueueNode<>(item);
        if (front == null) {
            front = temp;
            end = temp;
        } else {
            end.next = temp;
            end = end.next;
        }
    }

    public T remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        QueueNode<T> temp = front;
        front = front.next;
        if (front == null) {
            end = null;
        }
        return temp.data;
    }

}
