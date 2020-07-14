package com.pranavacharya.codechef;

import java.util.Scanner;

public class GIFTSRC {

    public int[] findDestination(String ip) {
        int x = 0;
        int y = 0;
        boolean xaxis = true;
        boolean yaxis = true;
        for (char c : ip.toCharArray()) {
            if (c == 'L' && xaxis) {
                xaxis = !xaxis;
                yaxis = true;
                x--;
            } else if (c == 'R' && xaxis) {
                xaxis = !xaxis;
                yaxis = true;
                x++;
            } else if (c == 'D' && yaxis) {
                yaxis = !yaxis;
                xaxis = true;
                y--;
            } else if (c == 'U' && yaxis) {
                yaxis = !yaxis;
                xaxis = true;
                y++;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String args[]) {
        GIFTSRC g = new GIFTSRC();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            String ip = sc.next();
            int[] c = g.findDestination(ip);
            sb.append(c[0]).append(" ").append(c[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
