package com.pranavacharya.kickoffs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EfficientShipping {

    public long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> ((int) (boxes.get(b) * unitsPerBox.get(b)) - (int) (boxes.get(a) * unitsPerBox.get(a))));
        for (int i = 0; i < boxes.size(); i++) {
            maxHeap.add(i);
        }
        long units = 0L;
        while (truckSize != 0 && !maxHeap.isEmpty()) {
            int highest = maxHeap.remove();
            long localbox = boxes.get(highest);
            long localunits = localbox * unitsPerBox.get(highest);
            if (localbox <= truckSize) {
                units += localunits;
                truckSize -= localbox;
            }
        }
        return units;
    }

    public static void main(String args[]) {
        EfficientShipping es = new EfficientShipping();
        List<Long> boxes = new ArrayList();
        boxes.add(4L);
        boxes.add(6L);
        boxes.add(5L);
        boxes.add(2L);
        boxes.add(7L);
        boxes.add(5L);
        List<Long> unitsPerBox = new ArrayList();
        unitsPerBox.add(46335L);
        unitsPerBox.add(90039L);
        unitsPerBox.add(24796L);
        unitsPerBox.add(87808L);
        unitsPerBox.add(17739L);
        unitsPerBox.add(610563L);
        System.out.println(es.getMaxUnits(boxes, unitsPerBox, 3));
    }
}
