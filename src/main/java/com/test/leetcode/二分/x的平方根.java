package com.test.leetcode.二分;

public class x的平方根 {

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long value =  (long) mid * mid;
            if (x == value) {
                return mid;
            } else if (value > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int mySqrt_1(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long value = (long) mid * mid;
            if (value > x) {
                right = mid - 1;
            } else if (value < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int i = mySqrt_1(2147395599);
        System.out.println(i);

        i = mySqrt(2147395599);
        System.out.println(i);
    }

}
