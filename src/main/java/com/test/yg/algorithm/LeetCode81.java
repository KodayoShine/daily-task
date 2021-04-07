package com.test.yg.algorithm;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (mid == target) {
                return true;
            }

            // nums[start] > nums[mid] 说明后半部分有序，反之前半部分有序。
            // 恰好相等的时候，你就不知道哪半部分有序了，
            // 所以需要 start ++，因为 nums[mid] == nums[start]，
            // 所以也不用害怕，start ++把需要找的数加没了。
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }

            // 这种情况下，前半部分有序
            if (nums[l] < nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}
