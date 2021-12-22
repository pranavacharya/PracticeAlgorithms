package com.pranavacharya.codeforces;

import java.util.Scanner;

public class YoungPhysicist {

    private String isEquilibrium(int[][] forces) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < forces.length; i++) {
            x += forces[i][0];
            y += forces[i][1];
            z += forces[i][2];
        }
        return (x == y && y == z && x == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        YoungPhysicist yp = new YoungPhysicist();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] forces = new int[t][3];
        for (int i = 0; i < t; i++) {
            forces[i][0] = sc.nextInt();
            forces[i][1] = sc.nextInt();
            forces[i][2] = sc.nextInt();
        }
        System.out.println(yp.isEquilibrium(forces));
    }
}
