package com.pranavacharya.hiringtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TanuTest {

    List<int[]> intervals = new ArrayList();
    HashMap<Integer, int[]> map = new HashMap();

    public TanuTest(int[] memory) {
        int index = 0;
        int last = memory[0];
        for (int i = 1; i < memory.length; i++) {
            if (memory[i] == 1) {
                if (last == 0) {
                    this.intervals.add(new int[]{index, i - 1});
                }
                last = 1;
            } else {
                if (last == 1) {
                    index = i;
                }
                last = 0;
            }
        }
        if (last == 0) {
            this.intervals.add(new int[]{index, memory.length - 1});
        }
    }

    private int alloc(int req) {
        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[1] - interval[0] + 1 >= req) {
                map.put(interval[0], new int[]{interval[0], Math.min(interval[1], interval[0] + req)});
                int id = interval[0];
                interval[0] = interval[0] + req;
                return id;
            }
        }
        return -1;
    }

    private int free(int id) {
        if (!this.map.containsKey(id)) {
            return -1;
        }
        int[] interval = this.map.get(id);
        this.intervals.add(interval);
        this.intervals = merge(this.intervals);
        return interval[1] - interval[0] - 1;
    }

    public List<int[]> merge(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        if (intervals.isEmpty()) {
            return new ArrayList();
        }
        ArrayList<int[]> list = new ArrayList();
        int[] curr = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i)[0] > curr[1]) {
                list.add(curr);
                curr = intervals.get(i);
            }
            if (intervals.get(i)[1] < curr[1]) {
                continue;
            }
            if (intervals.get(i)[0] <= curr[1]) {
                curr[1] = intervals.get(i)[1];
            }
        }
        list.add(curr);
        return list;
    }

    public static void main(String[] args) {
        int[] memory = new int[]{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0};
        TanuTest tt = new TanuTest(memory);
        System.out.println(tt.alloc(2));
        System.out.println(tt.alloc(1));
        System.out.println(tt.alloc(1));
        System.out.println(tt.free(2));
        System.out.println(tt.free(4));
        System.out.println(tt.alloc(4));
    }
}
