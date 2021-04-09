package com.pranavacharya.binarysearch;

import java.util.HashMap;

public class AmbigramDetection {

    HashMap<Character, Character> map = new HashMap();

    public boolean solve(String s, String[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            String[] pair = pairs[i];
            union(pair[0].charAt(0), pair[1].charAt(0));
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (findParent(s.charAt(i)) != findParent(s.charAt(s.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    private void union(Character x, Character y) {
        Character parentx = findParent(x);
        Character parenty = findParent(y);
        this.map.put(parenty, parentx);
    }

    private Character findParent(Character x) {
        Character child = x;
        while (this.map.containsKey(x)) {
            if (this.map.get(x).equals(x)) {
                break;
            }
            x = this.map.get(x);
        }
        this.map.put(child, x);
        return x;
    }

    public static void main(String[] args) {
        AmbigramDetection ad = new AmbigramDetection();
        String[][] pairs = new String[][]{{"a", "b"}, {"b", "c"}};
        System.out.println(ad.solve("ac", pairs));
    }
}
