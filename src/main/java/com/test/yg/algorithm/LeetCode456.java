package com.test.yg.algorithm;

import java.util.Stack;

/**
 * 132 模式
 * <p>
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：<b>i < j < k</b> 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * <p>
 * 由于要采用132的方式进行数组内的计算
 * 所以采用栈的方式
 * 那么根据题可以知道,最大的数在数组中间位置
 *
 */
public class LeetCode456 {

    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        // 2
        int last = Integer.MIN_VALUE;
        // 3
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            // 若出现132中的1则返回正确值
            if (nums[i] < last) {
                return true;
            }

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                last = stack.pop();
            }

            // 将当前值压入栈中
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        LeetCode456 leetCode456 = new LeetCode456();
        boolean pattern = leetCode456.find132pattern(new int[]{1, 2, 3, 4});
        System.out.println(pattern);
    }

}
