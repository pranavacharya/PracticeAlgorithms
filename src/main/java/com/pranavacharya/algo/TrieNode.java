package com.pranavacharya.algo;

public class TrieNode {

    private TrieNode[] links;
    private int L = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[L];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public TrieNode getLink(char c) {
        return this.links[c - 'a'];
    }

    public void putLink(char c, TrieNode node) {
        this.links[c - 'a'] = node;
    }

    public boolean containsKet(char c) {
        return links[c - 'a'] != null;
    }

}
