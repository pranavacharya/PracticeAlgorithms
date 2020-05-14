package com.pranavacharya.codeforces;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConstructingtheArray {

    public class Obj {

        int l;
        int r;
        int val;

        public Obj(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    class ObjComparator implements Comparator<Obj> {

        public int compare(Obj a, Obj b) {
            if ((b.r - b.l) - (a.r - a.l) != 0) {
                return (b.r - b.l) - (a.r - a.l);
            } else {
                return a.l - b.l;
            }
        }
    }

    public int[] constructArray(int length) {
        int[] result = new int[length];
        //bfs
        int n = 1;
        PriorityQueue<Obj> pqueue = new PriorityQueue<>(new ObjComparator());
        pqueue.add(new Obj(0, length - 1));
        while (!pqueue.isEmpty()) {
            Obj current = pqueue.remove();
            int l = current.l;
            int r = current.r;
            if (l <= r) {
                int mid;
                if ((r - l + 1) % 2 == 0) {
                    mid = (l + r - 1) / 2;
                } else {
                    mid = (l + r) / 2;
                }
                result[mid] = n;
                n++;
                if (mid - 1 - l >= r - (mid + 1)) {
                    pqueue.add(new Obj(l, mid - 1));
                    pqueue.add(new Obj(mid + 1, r));
                } else {
                    pqueue.add(new Obj(mid + 1, r));
                    pqueue.add(new Obj(l, mid - 1));
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        ConstructingtheArray cta = new ConstructingtheArray();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 1; i <= testCase; i++) {
            int length = sc.nextInt();
            int[] answer = cta.constructArray(length);
            for (int ans : answer) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
