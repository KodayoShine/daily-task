package com.test.yg.bit;

public class Operator {

    public static void main(String[] args) {
        Integer i = 1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int x = i << 32;
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
    }

}
