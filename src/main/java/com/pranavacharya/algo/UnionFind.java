package com.pranavacharya.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UnionFind {

    // element -> set representative
    HashMap<String, String> map = new HashMap();

    private void union(String x, String y) {
        String px = find(x);
        String py = find(y);
        this.map.put(py, px);
    }

    // a -> b, b -> c, c -> d
    // find(a) -> d
    private String find(String x) {
        if (!this.map.containsKey(x)) {
            this.map.put(x, x);
            return x;
        } else {
            String tempParent = this.map.get(x);
            while (!map.get(tempParent).equals(tempParent)) {
                tempParent = map.get(tempParent);
            }
            return tempParent;
        }
    }

    private List<List<String>> helper(List<List<String>> input) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> elements : input) {
            if (elements.isEmpty()) {
                continue;
            }
            String firstElement = elements.get(0);
            for (int i = 1; i < elements.size(); i++) {
                System.out.println("connecting edge " + firstElement + " with " + elements.get(i));
                union(firstElement, elements.get(i));
                System.out.println(this.map);
            }
        }
        HashMap<String, HashSet<String>> tmpResult = new HashMap();
        for (List<String> elements : input) {
            for (int i = 0; i < elements.size(); i++) {
                String representative = find(elements.get(i));
                tmpResult.putIfAbsent(representative, new HashSet());
                tmpResult.get(representative).add(elements.get(i));
            }
        }
        for (String key: tmpResult.keySet()) {
            result.add(new ArrayList(tmpResult.get(key)));
        }
        return result;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        List<List<String>> list = new ArrayList();
        List<String> one = new ArrayList();
        List<String> two = new ArrayList();
        List<String> three = new ArrayList();
        one.add("oranges");
        one.add("dogs");
        one.add("apples");
        two.add("peach");
        two.add("mango");
        three.add("cats");
        three.add("dogs");
        list.add(one);
        list.add(two);
        list.add(three);
        System.out.println(uf.helper(list));
    }
}


/**
 * connecting edge oranges with dogs
{oranges=oranges, dogs=oranges}
connecting edge oranges with apples
{oranges=oranges, dogs=oranges, apples=oranges}
connecting edge peach with mango
{oranges=oranges, dogs=oranges, peach=peach, apples=oranges, mango=peach}
connecting edge dogs with cats
{oranges=oranges, cats=oranges, dogs=oranges, peach=peach, apples=oranges, mango=peach}
 */