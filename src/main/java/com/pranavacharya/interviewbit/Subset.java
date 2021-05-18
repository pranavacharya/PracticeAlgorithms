package com.pranavacharya.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if (A == null) {
            return null;
        }
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        for (int i = 0; i < A.size(); i++) {
            backtracking(A, result, i, new ArrayList());
        }
        return result;
    }

    private void backtracking(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, int index, ArrayList<Integer> path) {
        path.add(A.get(index));
        ans.add(path);
        if (index == A.size()) {
            return;
        }
        for (int j = index + 1; j < A.size(); j++) {
            backtracking(A, ans, j, new ArrayList(path));
        }
    }

    public static void main(String[] args) {
        Subset s = new Subset();
        ArrayList<Integer> A = new ArrayList();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(s.subsets(A));
    }
}
//1,2,3
