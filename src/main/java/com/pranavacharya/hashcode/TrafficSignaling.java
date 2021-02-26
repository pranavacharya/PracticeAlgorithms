package com.pranavacharya.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TrafficSignaling {

    public class Street {

        int end;
        String name;
        int length;
        int greenTime;

        public Street(int end, String name, int length) {
            this.end = end;
            this.name = name;
            this.length = length;
            this.greenTime = 1;
        }

        @Override
        public String toString() {
            return "" + end + " " + name + " " + length;
        }
    }

    public static void main(String[] args) {
        TrafficSignaling ts = new TrafficSignaling();
        ts.scheduleTraffic();
    }

    public void scheduleTraffic() {
        Scanner sc = new Scanner(System.in);
        int simulationTime = sc.nextInt();
        int nodes = sc.nextInt();
        int streets = sc.nextInt();
        int carCount = sc.nextInt();
        int points = sc.nextInt();

        // indegree
        HashMap<Integer, Integer> indegree = new HashMap();

        // streename
        HashMap<String, Street> streetName = new HashMap();

        // graph
        HashMap<Integer, ArrayList<Street>> graph = new HashMap();

        // intitialize nodes
        for (int i = 0; i < nodes; i++) {
            graph.put(i, new ArrayList());
        }

        for (int i = 0; i < streets; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            String name = sc.next();
            int length = sc.nextInt();
            Street st = new Street(end, name, length);
            graph.get(start).add(st);

            indegree.put(end, indegree.getOrDefault(end, 0) + 1);

            streetName.put(name, st);
        }

        // car paths
        HashMap<Integer, ArrayList<String>> carPaths = new HashMap();
        for (int i = 1; i <= carCount; i++) {
            ArrayList<String> path = new ArrayList();
            int stCount = sc.nextInt();
            for (int j = 0; j < stCount; j++) {
                String name = sc.next();
                path.add(name);
            }
            carPaths.put(i, path);
        }

        // cars which can complete in time with no signal
        HashSet<Integer> validCars = new HashSet();

        //PriorityQueue for longest car path
        PriorityQueue<int[]> carTime = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 1; i <= carCount; i++) {
            int timetaken = findTimeTaken(graph, streetName, carPaths.get(i));
            if (timetaken <= simulationTime) {
                validCars.add(i);
                carTime.add(new int[]{i, timetaken});
            }
        }

        HashMap<Integer, ArrayList<Street>> intersec = new HashMap();

        while (!carTime.isEmpty()) {
            int[] ct = carTime.poll();
            int c = ct[0];
            assignGreenTime(graph, streetName, carPaths.get(c), intersec, simulationTime);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(intersec.size()).append("\n");
        for (int key : intersec.keySet()) {
            sb.append(key).append("\n");
            ArrayList<Street> list = intersec.get(key);
            sb.append(list.size()).append("\n");
            for (int i = 0; i < list.size(); i++) {
                Street st = list.get(i);
                sb.append(st.name).append(" ").append(st.greenTime).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private int findTimeTaken(HashMap<Integer, ArrayList<Street>> graph, HashMap<String, Street> streetName, ArrayList<String> path) {
        int time = 0;
        if (path.isEmpty() || path.size() == 1) {
            return time;
        }
        for (int i = 1; i < path.size(); i++) {
            Street st = streetName.get(path.get(i));
            time += st.length;
        }
        return time;
    }

    private void assignGreenTime(HashMap<Integer, ArrayList<Street>> graph, HashMap<String, Street> streetName, ArrayList<String> path,
            HashMap<Integer, ArrayList<Street>> intersec, int simulationTime) {
        int time = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Street st = streetName.get(path.get(i));
            if (i != 0) {
                time += st.length + 1;
            }
            st.greenTime = Math.min(simulationTime, Math.max(time, st.greenTime));
            intersec.putIfAbsent(st.end, new ArrayList());
            if (!intersec.get(st.end).contains(st)) {
                intersec.get(st.end).add(st);
            }
        }
    }

}
