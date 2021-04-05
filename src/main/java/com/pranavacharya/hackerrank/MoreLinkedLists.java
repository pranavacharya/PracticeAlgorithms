package com.pranavacharya.hackerrank;

import java.util.HashSet;

public class MoreLinkedLists {

    private class Node {

        int data;
        Node next;
    }

    public static Node removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet();
        Node temp = head;
        if (temp == null) {
            return null;
        }
        set.add(temp.data);
        while (temp.next != null) {
            if (set.contains(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.data);
                temp = temp.next;
            }
        }
        return head;
    }

}
