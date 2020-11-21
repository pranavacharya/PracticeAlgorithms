package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.Scanner;

public class CHEFDETE {

    public ArrayList<Integer> findLeaves(int[] arr) {
        int[] indegree = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            indegree[arr[i]]++;
        }
        ArrayList<Integer> leaves = new ArrayList();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                leaves.add(i);
            }
        }
        return leaves;
    }

    public static void main(String args[]) {
        CHEFDETE c = new CHEFDETE();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> res = c.findLeaves(arr);
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(" ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
