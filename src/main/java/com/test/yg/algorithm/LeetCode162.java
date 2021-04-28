package com.test.yg.algorithm;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class LeetCode162 {

    /**
     * 为什么二分查找大的那一半一定会有峰值呢？（即nums[mid]<nums[mid+1]时，mid+1~N一定存在峰值）
     *
     * 我的理解是，首先已知 nums[mid+1]>nums[mid]，那么mid+2只有两种可能，一个是大于mid+1，一个是小于mid+1，
     * 小于mid+1的情况，那么mid+1就是峰值，
     * 大于mid+1的情况，继续向右推，如果一直到数组的末尾都是大于的，
     * 那么可以肯定最后一个元素是峰值，因为nums[nums.length]=负无穷
     *
     *
     * 如果 nums[mid] > max(nums[mid-1], nums[mid+1])	mid 即为所求
     * 如果 nums[mid] < nums[mid+1]			[mid+1, n-1] 范围内必然有一个峰值
     * 如果 nums[mid] < nums[mid-1]			[0, mid-1] 范围内必然有一个峰值
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
