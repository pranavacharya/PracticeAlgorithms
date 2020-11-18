package com.pranavacharya.codechef;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FEMA2 {

    private int findMaxMagnet(String s, int k) {
        int count = 0;
        String[] segments = s.split("X");
        for (String segment : segments) {
            count += findMaxMagnetOfSegment(k, segment);
        }
        return count;
    }

    private int findMaxMagnetOfSegment(int k, String segment) {
        int pairs = 0;
        Queue<Integer> magnets = new LinkedList();
        Queue<Integer> irons = new LinkedList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < segment.length(); i++) {
            if (segment.charAt(i) == ':') {
                sb.append(':');
            }
            sb.append(segment.charAt(i));
        }
        segment = sb.toString();
        for (int i = 0; i < segment.length(); i++) {
            if (segment.charAt(i) == 'M') {
                while (!irons.isEmpty() && Math.abs(i - irons.peek()) > k) {
                    irons.poll();
                }
                if (irons.isEmpty()) {
                    magnets.add(i);
                } else {
                    pairs++;
                    irons.poll();
                }
            } else if (segment.charAt(i) == 'I') {
                while (!magnets.isEmpty() && Math.abs(i - magnets.peek()) > k) {
                    magnets.poll();
                }
                if (magnets.isEmpty()) {
                    irons.add(i);
                } else {
                    pairs++;
                    magnets.poll();
                }
            }
        }
        return pairs;
    }

    public static void main(String args[]) {
        FEMA2 f = new FEMA2();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            sb.append(f.findMaxMagnet(s, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
