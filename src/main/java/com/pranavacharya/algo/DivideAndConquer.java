package com.pranavacharya.algo;

public class DivideAndConquer {
    
    public static String leastCommonPrefix (String[] ip) { 
        if (ip.length == 0 || ip == null)
            return "";
        int left = 0;
        int right = ip.length -1;
        return leastCommonPrefix(ip, left, right);     
    }
    
    public static String leastCommonPrefix(String[] input, int l, int r){
        if(l == r)
            return input[l];
        else {
            int middle = (l + r) / 2;
            String lans = leastCommonPrefix(input, l, middle);
            String rans = leastCommonPrefix(input, middle + 1, r);
            return commonPrefix(lans,rans);
        }
    }
    
    public static String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if(left.charAt(i) != right.charAt(i))
                return left.substring(0,i);
        }
        return left.substring(0, min);
    }
    
    public static void main (String args[]) {
        String[] input = {"pranav"};
        System.out.println(leastCommonPrefix(input));
    }

}
