package com.pranavacharya.algo;

public class Karatsuba {

    public static void main(String[] args) {
        System.out.println("Hello World");
        String prod = multiply("1241412", "4124121");
        System.out.println(prod);

    }

    public static String multiply(String n1, String n2) {
        int len1 = n1.length();
        int len2 = n2.length();

        if (len1 < 10 || len2 < 10) {
            return Long.toString(Long.parseLong(n1) * Long.parseLong(n2));
        }

        int minLength = Math.min(len1, len2);
        int mid = minLength / 2;

        String high1 = n1.substring(0, mid + 1);
        String low1 = n1.substring(mid + 1);

        String high2 = n2.substring(0, mid + 1);
        String low2 = n2.substring(mid + 1);

        String z0 = multiply(low1, low2);
        String z1 = multiply((low1 + high1), (low2 + high2));
        String z2 = multiply(high1, high2);

        return Long.toString((long) (Long.parseLong(z2) * Math.pow(10, mid * 2) + ((Long.parseLong(z1) - Long.parseLong(z2) - Long.parseLong(z0)) * Math.pow(10, mid)) + Long.parseLong(z0)));
    }
}
