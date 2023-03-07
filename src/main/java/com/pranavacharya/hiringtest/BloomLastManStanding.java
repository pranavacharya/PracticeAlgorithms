/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pranavacharya.hiringtest;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author pranav
 */
public class BloomLastManStanding {

    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() != 1) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            int x = q.poll();
            if (q.size() == 1) {
                System.out.println(x);
            }

        }
        return q.poll();
    }

    public static void main(String[] args) {
        BloomLastManStanding blms = new BloomLastManStanding();
        System.out.println(blms.findTheWinner(5, 2));
        System.out.println(blms.findTheWinner(7, 2));
    }

}
