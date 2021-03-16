package com.pranavacharya.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class APersonalDictionary {

    private String findOrder(String[] strs) {
        HashMap<Character, ArrayList<Character>> adj = new HashMap();
        char[] indegree = new char[26];
        // max Length
        for (int j = 0; j <= 26; j++) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() - 1 < j) {
                    continue;
                }
                String sub = strs[i].substring(0, j);
                for (int k = i + 1; k < strs.length; k++) {
                    if (strs[k].length() - 1 < j) {
                        continue;
                    }
                    if (sub.equals(strs[k].substring(0, j))) {
                        adj.putIfAbsent(strs[i].charAt(j), new ArrayList());
                        if (strs[i].charAt(j) != strs[k].charAt(j)
                                && !adj.get(strs[i].charAt(j)).contains(strs[k].charAt(j))) {
                            adj.get(strs[i].charAt(j)).add(strs[k].charAt(j));
                            indegree[strs[k].charAt(j) - 'a']++;
                        }
                    }
                }

            }
        }

        // top sort
        Queue<Character> queue = new LinkedList();
        for (char i = 'a'; i <= 'z'; i++) {
            if (indegree[i - 'a'] == 0 && adj.containsKey(i)) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            ArrayList<Character> neighbours = adj.getOrDefault(curr, new ArrayList());
            for (int i = 0; i < neighbours.size(); i++) {
                indegree[neighbours.get(i) - 'a']--;
                if (indegree[neighbours.get(i) - 'a'] == 0) {
                    queue.add(neighbours.get(i));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        APersonalDictionary pd = new APersonalDictionary();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        System.out.println(pd.findOrder(strs));
    }
}
