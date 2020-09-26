package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.Scanner;

public class BOWLERS {

    public ArrayList<Integer> findValid(int n, int k, int l) {
        ArrayList<Integer> list = new ArrayList();
        if (k * l < n || (n > 1 && k == 1)) {
            list.add(-1);
            return list;
        }
        int j = 0;
        for (int i = 1; i <= n; i++) {
            j = j % k;
            list.add(j + 1);
            j++;
        }
        return list;
    }

    public static void main(String args[]) {
        BOWLERS b = new BOWLERS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            ArrayList<Integer> ans = b.findValid(n, k, l);
            StringBuilder temp = new StringBuilder();
            for (int val : ans) {
                temp.append(val).append(" ");
            }
            sb.append(temp.toString().trim()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
