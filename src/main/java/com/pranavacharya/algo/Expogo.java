package com.pranavacharya.algo;

import java.util.Scanner;

public class Expogo {

    public void reachTarget(int caseno, int x, int y) {
        dfs(caseno, 0, 0, 0, "", x, y);
    }

    public void dfs(int caseno, int cx, int cy, int jump, String path, int x, int y) {
        if (jump > 3) {
            return;
        }
        if (cx == x && cy == y) {
            System.out.format("Case #%d: %s", caseno, path);
            System.out.println();
            return;
        }
        //s
        dfs(caseno, cx, (cy - (int) Math.pow(2, jump)), jump + 1, new String(path).concat("S"), x, y);
        //e
        dfs(caseno, (cx + (int) Math.pow(2, jump)), cy, jump + 1, new String(path).concat("E"), x, y);
        //n
        dfs(caseno, cx, (cy + (int) Math.pow(2, jump)), jump + 1, new String(path).concat("N"), x, y);
        //w
        dfs(caseno, (cx - (int) Math.pow(2, jump)), cy, jump + 1, new String(path).concat("W"), x, y);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Expogo v = new Expogo();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            v.reachTarget(t, x, y);
        }
    }
}
