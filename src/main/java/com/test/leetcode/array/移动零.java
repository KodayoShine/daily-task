package com.test.leetcode.array;

public class 移动零 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 通过指针变量,保存当前数组中所要放置数据的位置
     * 然后依次找非0的数据,进行值的替换
     * <p>
     * 处理完数据后,指针变量后续的值都置为0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int t = 0;
        for (int currt = 0; currt < nums.length; currt++) {
            if (nums[currt] != 0) {
                nums[t++] = nums[currt];
            }
        }

        for (; t < nums.length; t++) {
            nums[t] = 0;
        }
    }


}
