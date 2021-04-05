package com.test.yg.algorithm;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class LeetCode88 {

    /**
     * 解题思路:
     * 由于nums1中的长度是m + n的长度
     * 保证每次的值都是最大的, 依次的插入到后面即可
     * 一旦m或者n长度为0的情况下,只需要将其余的值按照剩余的顺序排列到nums1中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; ) {
            int numSize = i + j + 1;
            if (i >= 0 && j >= 0) {
                int mValue = nums1[i];
                int nValue = nums2[j];
                if (mValue >= nValue) {
                    nums1[numSize] = nums1[i];
                    i--;
                } else {
                    nums1[numSize] = nums2[j];
                    j--;
                }
            } else if (i >= 0) {
                nums1[numSize] = nums1[i];
                i--;
            } else {
                nums1[numSize] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode88 leetCode88 = new LeetCode88();
        //int[] nums1 = {1, 2, 3, 0, 0, 0};
        //leetCode88.merge(nums1, 3, new int[]{2, 5, 6}, 3);

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        leetCode88.merge(nums1, 3, new int[]{2, 5, 6}, 3);

        for (int i : nums1) {
            System.out.println(i);
        }

    }

}
