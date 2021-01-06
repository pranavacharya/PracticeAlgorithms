package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class BILLRD {

    private int[] findCordinated(int n, int k, int x, int y) {
        if (x == y) {
            return new int[]{n, n};
        }
        HashMap<Integer, int[]> map = new HashMap();
        if (x > y) {
            int slope = 1;
            int a = n;
            int b = 0;
            for (int i = 0; i < 4; i++) {
                int[] intersect = findIntesectionY(x, y, a, b, slope);
                slope *= -1;
                if (slope == 1) {
                    a = 0;
                }
                x = intersect[0];
                y = intersect[1];
                map.put(i, new int[]{x, y});
            }
        } else {
            int slope = 1;
            int a = 0;
            int b = n;
            for (int i = 0; i < 4; i++) {
                int[] intersect = findIntesectionX(x, y, a, b, slope);
                slope *= -1;
                if (slope == 1) {
                    b = 0;
                }
                x = intersect[0];
                y = intersect[1];
                map.put(i, new int[]{x, y});
            }
        }
        return map.get((k - 1) % 4);
    }

    private int[] findIntesectionY(int x, int y, int a, int b, int slope) {
        if (slope == -1) {
            a = y;
            b = x;
        } else {
            a = a;
            b = a - x + y;
        }
        return new int[]{a, b};
    }

    private int[] findIntesectionX(int x, int y, int a, int b, int slope) {
        if (slope == -1) {
            a = y;
            b = x;
        } else {
            b = b;
            a = b - y + x;
        }
        return new int[]{a, b};
    }

    public static void main(String args[]) {
        BILLRD b = new BILLRD();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] ans = b.findCordinated(n, k, x, y);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
