package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHEFSTEP {
    
    public String isCoverd(int[] dist, int k) {
        StringBuilder sb = new StringBuilder();
        for (int d : dist) {
            if (d % k == 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
    
    public static void main(String args[]) {
        CHEFSTEP c = new CHEFSTEP();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            int[] dist = new int[len];
            for (int j = 0; j < len; j++) {
                dist[j] = sc.nextInt();
            }
            sb.append(c.isCoverd(dist, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
