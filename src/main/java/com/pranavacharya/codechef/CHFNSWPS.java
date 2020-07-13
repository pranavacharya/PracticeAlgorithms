package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CHFNSWPS {

    public long findMindCost(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b, int min) {
        for (int key : a.keySet()) {
            int acount = a.get(key);
            if (b.containsKey(key)) {
                int bcount = b.get(key);
                a.put(key, acount - Math.min(acount, bcount));
                b.put(key, bcount - Math.min(acount, bcount));
            }
        }
        ArrayList<Integer> alist = new ArrayList();
        ArrayList<Integer> blist = new ArrayList();
        for (int key : a.keySet()) {
            int count = a.get(key);
            for (int i = 1; i <= count / 2; i++) {
                alist.add(key);
            }
        }
        for (int key : b.keySet()) {
            int count = b.get(key);
            for (int i = 1; i <= count / 2; i++) {
                blist.add(key);
            }
        }
        if (alist.isEmpty() && blist.isEmpty()) {
            return 0;
        }
        Collections.sort(alist);
        Collections.sort(blist);
        long ans = 0;
        int size = alist.size();
        for (int i = 0; i < size; i++) {
            ans += Math.min(2 * min, Math.min(alist.get(i), blist.get(size - 1 - i)));
        }
        return ans;
    }

    public static void main(String args[]) {
        CHFNSWPS c = new CHFNSWPS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> a = new HashMap();
            HashMap<Integer, Integer> b = new HashMap();
            int min = Integer.MAX_VALUE;
            int checkEven = 0;
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                a.put(val, a.getOrDefault(val, 0) + 1);
                min = Math.min(min, val);
                checkEven ^= val;
            }
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                b.put(val, b.getOrDefault(val, 0) + 1);
                min = Math.min(min, val);
                checkEven ^= val;
            }
            if (checkEven != 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(c.findMindCost(a, b, min)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
