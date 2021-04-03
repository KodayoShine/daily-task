package com.test.yg.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59_1 {

    /**
     * 维护一块队列,内部维护着当前滑动块内的最大值
     * 当前滑动块超过k值,每次都将队列的首值获取到,放入到数组中
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> max = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for(int r = 0; r < nums.length; r++) {
            while(!max.isEmpty() && max.peekLast() < nums[r]) {
                max.removeLast();
            }
            max.addLast(nums[r]);

            int l = r - k + 1;
            // 删除 max 中对应的 nums[l-1]
            if(l > 0 && max.peek() == nums[l - 1]) {
                max.removeFirst();
            }

            // 记录窗口最大值
            if(l >= 0) {
                res[l] = max.peek();
            }
        }

        return res;
    }


    /**
     * 较为暴力的解析方式,计算每个滑动块的内的数据大小
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
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

    private int maxValue(int[] nums, int l, int r) {
        int max = nums[l];
        for (; l <= r; l++) {
            max = Math.max(max, nums[l]);
        }
        return max;
    }

    public static void main(String[] args) {
        Offer59_1 offer59_1 = new Offer59_1();
        int[] ints = offer59_1.maxSlidingWindow(new int[]{1,-1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
