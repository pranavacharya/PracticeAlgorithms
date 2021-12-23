package com.pranavacharya.codeforces;

import java.util.Scanner;

public class QueueattheSchool {

    private String findQueue(int n, int t, String queue) {
        char[] q = queue.toCharArray();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < q.length - 1; j++) {
                if (q[j] == 'B' && q[j + 1] == 'G') {
                    q[j] = 'G';
                    q[j + 1] = 'B';
                    j++;
                }
            }
        }
        return new String(q);
    }

    public static void main(String[] args) {
        QueueattheSchool qats = new QueueattheSchool();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String queue = sc.next();
        System.out.println(qats.findQueue(n, t, queue));
    }
}
