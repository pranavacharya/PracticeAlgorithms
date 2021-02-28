package com.pranavacharya.hackerearth;

import java.util.Scanner;

public class EeriePlanet {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int totalHours = sc.nextInt();
        int c = sc.nextInt();
        int q = sc.nextInt();
        int[] hours = new int[totalHours + 1];
        for (int i = 0; i < c; i++) {
            int height = sc.nextInt();
            int low = sc.nextInt();
            int high = sc.nextInt();
            for (int j = low; j <= high; j++) {
                hours[j] = Math.max(hours[j], height);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int height = sc.nextInt();
            int hour = sc.nextInt();
            if (hour < hours.length && hours[hour] < height) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
