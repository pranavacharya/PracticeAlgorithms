package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RBGQueries {

    class Color {

        int r;
        int g;
        int b;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public static List<String> mixColors(List<List<Integer>> colors, List<List<Integer>> queries) {
        HashMap<Integer, ArrayList<int[]>> red = new HashMap();
        HashMap<Integer, ArrayList<int[]>> green = new HashMap();
        HashMap<Integer, ArrayList<int[]>> blue = new HashMap();
        for (List<Integer> list : colors) {
            int[] color = new int[]{list.get(0), list.get(1), list.get(2)};
            ArrayList<int[]> tempred = red.getOrDefault(list.get(0), new ArrayList());
            tempred.add(color);
            red.put(list.get(0), tempred);
            ArrayList<int[]> tempgreen = green.getOrDefault(list.get(1), new ArrayList());
            tempgreen.add(color);
            green.put(list.get(1), tempgreen);
            ArrayList<int[]> tempblue = blue.getOrDefault(list.get(2), new ArrayList());
            tempblue.add(color);
            blue.put(list.get(2), tempblue);
        }
        List<String> response = new ArrayList();

        for (List<Integer> list : queries) {
//            int[] color = new int[]{list.get(0), list.get(1), list.get(2)};
            ArrayList<int[]> redList = red.getOrDefault(list.get(0), new ArrayList());
            ArrayList<int[]> greenList = green.getOrDefault(list.get(1), new ArrayList());
            ArrayList<int[]> blueList = blue.getOrDefault(list.get(2), new ArrayList());
            boolean status = false;
            for (int[] color : redList) {
                if (color[1] <= list.get(1) && color[2] <= list.get(2)) {
                    status = true;
                }
            }
            if (!status) {
                response.add("NO");
                continue;
            }
            status = false;
            for (int[] color : greenList) {
                if (color[0] <= list.get(0) && color[2] <= list.get(2)) {
                    status = true;
                }
            }
            if (!status) {
                response.add("NO");
                continue;
            }
            status = false;
            for (int[] color : blueList) {
                if (color[1] <= list.get(1) && color[0] <= list.get(0)) {
                    status = true;
                }
            }
            if (status) {
                response.add("YES");
            } else {
                response.add("NO");
            }
        }
        return response;
    }
}
