package com.test.yg.algorithm;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59_1 {

    /**
     * 较为暴力的解析方式,计算每个滑动块的内的数据大小
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        for (int l = 0; l < nums.length - k + 1; l++) {
            int r = l + k - 1;
            res[l] = maxValue(nums, l, r);
        }
        return res;
    }

    private int maxValue(int[] nums, int l, int r){
        int max = nums[l];
        for (; l <= r; l++) {
            max = Math.max(max, nums[l]);
        }
        return max;
    }

    public static void main(String[] args) {
        Offer59_1 offer59_1 = new Offer59_1();
        int[] ints = offer59_1.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
