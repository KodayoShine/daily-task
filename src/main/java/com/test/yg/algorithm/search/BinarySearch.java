package com.test.yg.algorithm.search;

/**
 * 二分的方式查询旋转的数据
 * <p>
 * 主要理解二分的查询方式
 *
 * @author sunshine
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i;
                break;
            }
        }
        int ans = find(nums, 0, idx, target);
        if (ans != -1) {
            return ans;
        }
        if (idx + 1 < n) {
            ans = find(nums, idx + 1, n - 1, target);
        }
        return ans;
    }

    int find(int[] nums, int l, int r, int target) {
        while (l <= r) {
            // 如果单纯使用 (l + r ) >> 1
            // 可能回到数值溢出
            int mid = l + (r - l) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


}
