package com.pranavacharya.codechef;

import java.util.HashSet;
import java.util.Scanner;

public class FEMA2 {

    private int findMaxMagnet(String s, int k) {
        int count = 0;
        String[] segments = s.split("X");
        for (String segment : segments) {
            HashSet<Integer> set = new HashSet();
            for (int i = 0; i < segment.length(); i++) {
                if (segment.charAt(i) == 'M') {
                    int min = Integer.MAX_VALUE;
                    int minIndex = -1;
                    int index = i;
                    int cs = 0;
                    while (index >= 0) {
                        if (set.contains(index)) {

                        } else if (segment.charAt(index) == ':') {
                            cs++;
                        } else if (segment.charAt(index) == 'I') {
                            int dist = Math.abs(index - i);
                            int force = k + 1 - dist - cs;
                            if (force > 0) {
                                if (force < min) {
                                    min = force;
                                    minIndex = index;
                                }
                            }
                        }
                        index--;
                    }
                    cs = 0;
                    index = i;
                    while (index < segment.length()) {
                        if (set.contains(index)) {

                        } else if (segment.charAt(index) == ':') {
                            cs++;
                        } else if (segment.charAt(index) == 'I') {
                            int dist = Math.abs(index - i);
                            int force = k + 1 - dist - cs;
                            if (force > 0) {
                                if (force < min) {
                                    min = force;
                                    minIndex = index;
                                }
                            }
                        }
                        index++;
                    }
                    if (min != Integer.MAX_VALUE) {
                        set.add(minIndex);
                    }
                }
            }
            count += set.size();
        }
        return count;
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
