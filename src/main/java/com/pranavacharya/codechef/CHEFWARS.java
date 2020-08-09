package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHEFWARS {

    public int canDefeat(int hp, int p) {
        while (hp > 0 && p > 0) {
            hp -= p;
            p /= 2;
        }
        return hp <= 0 && p >= 0 ? 1 : 0;
    }

    public static void main(String args[]) {
        CHEFWARS c = new CHEFWARS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int hp = sc.nextInt();
            int p = sc.nextInt();
            sb.append(c.canDefeat(hp, p)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
