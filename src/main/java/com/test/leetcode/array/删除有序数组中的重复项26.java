package com.test.leetcode.array;

import java.util.Arrays;

public class 删除有序数组中的重复项26 {

    /**
     * 需要考虑解题的方式,采用快慢指针的方式,进行解题
     * <p>
     * 快指针用于处理当前元素,慢指针用于确定没有重复的指针
     *
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    public static int removeDuplicates_2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 5, 7, 8, 8};
        int i = removeDuplicates_2(nums);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println(i);
    }

}
