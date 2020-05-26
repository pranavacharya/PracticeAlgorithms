package com.pranavacharya.algo;

public class TreiOperations {

    private TrieNode root;

    public TreiOperations() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode head = root;
        char[] arr = word.toCharArray();
        int index = 0;
        while (head.containsKet(arr[index])) {
            head = head.getLink(arr[index]);
            index++;
        }
        while (index < arr.length) {
            head.putLink(arr[index], new TrieNode());
            head = head.getLink(arr[index]);
            index++;
        }
        head.setEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode head = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (head.containsKet(prefix.charAt(i))) {
                head = head.getLink(prefix.charAt(i));
            } else {
                return null;
            }
        }
        return head;
    }

    public boolean search(String word) {
        TrieNode head = searchPrefix(word);
        return head != null && head.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode head = searchPrefix(prefix);
        return head != null;
    }

    public static void main(String args[]) {
        TreiOperations ops = new TreiOperations();
        ops.addWord("pranav");
        ops.addWord("pravina");
        ops.addWord("acharya");

        System.out.println(ops.search("appu"));
        System.out.println(ops.search("pranav"));
        System.out.println(ops.search("achar"));

        System.out.println(ops.startsWith("achar"));

    }
}
