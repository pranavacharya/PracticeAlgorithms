package com.pranavacharya.binarysearch;

import java.util.HashMap;

public class LeastRecentlyUsedCache {

    class DoubleLL {

        DoubleLL next;
        DoubleLL prev;
        int key;
        int val;
    }

    private DoubleLL head;
    private DoubleLL tail;
    private int capacity;
    private HashMap<Integer, DoubleLL> cache;
    private int length;

    public LeastRecentlyUsedCache(int capacity) {
        this.head = new DoubleLL();
        this.tail = new DoubleLL();

        this.head.prev = null;
        this.tail.next = null;

        this.head.next = tail;
        this.tail.prev = head;

        this.capacity = capacity;
        this.cache = new HashMap();
        this.length = 0;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            DoubleLL node = this.cache.get(key);
            this.moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int val) {

        if (this.cache.containsKey(key)) {
            DoubleLL node = this.cache.get(key);
            node.val = val;
            this.moveToHead(node);
        } else {
            DoubleLL node = new DoubleLL();
            node.key = key;
            node.val = val;
            this.cache.put(key, node);
            this.addNodeAtHead(node);
            this.length++;
            if (this.length > this.capacity) {
                DoubleLL last = this.removeNodeAtTail();
                this.cache.remove(last.key);
                this.length--;
            }
        }

    }

    private void addNodeAtHead(DoubleLL node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    private void removeNode(DoubleLL node) {
        DoubleLL previous = node.prev;
        DoubleLL next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    private DoubleLL removeNodeAtTail() {
        DoubleLL lastNode = tail.prev;
        this.removeNode(lastNode);
        return lastNode;
    }

    private void moveToHead(DoubleLL node) {
        this.removeNode(node);
        this.addNodeAtHead(node);
    }

    public static void main(String args[]) {
        LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2 /* capacity */);

        cache.set(4, 0);
        cache.set(4, 4);
        System.out.println(cache.get(3));       // returns 1
    }
}
