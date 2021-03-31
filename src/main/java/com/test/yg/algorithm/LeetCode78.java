package com.test.yg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class LeetCode78 {

    /**
     * 遍历数组,对于数组的每一个整数,每一步都输出子集中所有子集添加这个整数,并生成新的子集
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = arrayList.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(arrayList.get(j));
                tmp.add(nums[i]);
                arrayList.add(tmp);
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        leetCode78.subsets(new int[]{1,2,3});
    }


}
