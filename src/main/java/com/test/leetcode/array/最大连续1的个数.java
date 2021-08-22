package com.test.leetcode.array;

public class 最大连续1的个数 {


    /**
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     * <p>
     * 通过两个变量,处理当前连续数和最大连续数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == 1 ? 1 : 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

}
