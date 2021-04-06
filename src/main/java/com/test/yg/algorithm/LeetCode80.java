package com.test.yg.algorithm;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode80 {


    /**
     * 采用快慢指针的方式
     * 快指针用于遍历全部元素
     * 慢指针处理当前所要处理元素的指针
     *
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            // 如果nums[slow - 2] == nums[fast]，代表已经有两个数相等，此时nums[fast]
            // 对应的数值不能放进结果之中。反之，如果nums[slow - 2] != nums[fast]，
            // 那么nums[fast]可以放进nums[slow]中，并且slow++，记录结果的长度。
            if (slow < 2 || nums[slow - 2] < nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode80 leetCode80 = new LeetCode80();
        leetCode80.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 4});
    }

}
