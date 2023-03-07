package com.pranavacharya.hiringtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TanmayTest {

    private Boolean[] helper(int[][] ops) {
        List<Boolean> list = new ArrayList();
        int len = Integer.MAX_VALUE;
        int bth = Integer.MAX_VALUE;
        for (int[] op : ops) {
            if (op[0] == 0) {
                int a = op[1];
                int b = op[2];
                if (b < a) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                len = Math.min(len, a);
                bth = Math.min(bth, b);
            } else {
                int a = op[1];
                int b = op[2];
                if (b < a) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                if (a <= len && b <= bth) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }
        }
        int index = 0;
        Boolean[] ans = new Boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[index++] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TanmayTest tt = new TanmayTest();
        int[][] ops = new int[][]{{0, 3, 3}, {0, 5, 2}, {1, 3, 2}, {1, 2, 4}};
        System.out.println(Arrays.toString(tt.helper(ops)));
    }
}
