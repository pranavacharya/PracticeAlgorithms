package com.pranavacharya.cses;

import java.util.Scanner;

public class Permutations {

    public void printlnPermutation(int n) {
        if (n == 3 || n == 2) {
            System.out.println("NO SOLUTION");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i = i + 2) {
            sb.append(i + " ");
        }
        for (int i = 1; i <= n; i = i + 2) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
        return;
    }

    public static void main(String args[]) {
        Permutations p = new Permutations();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p.printlnPermutation(n);
    }
}
