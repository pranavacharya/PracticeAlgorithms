
package com.pranavacharya.hiringtest;

import java.util.HashSet;

public class AmazonParcel {
    private int findMinDays(int[] parcels) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < parcels.length; i++) {
            set.add(parcels[i]); 
        }
        
        if(set.contains(0)) {
            set.remove(0);
        }
        return set.size();
    }
    
    public static void main(String[] args) {
        AmazonParcel a = new AmazonParcel();
        int[] parcels = new int[]{2, 3, 4, 3, 3};
        System.out.println(a.findMinDays(parcels));
    }
}
