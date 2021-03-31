package com.test.yg.algorithm;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class LeetCode90 {

    Set<List<Integer>> res = new HashSet<>();

    /**
     * 和leetCode78采用相同的解决思路(没啥思路)
     * 将原本使用list接收参数的集合 采用set 帮忙做去重处理
     *
     * 并且需要对数组进行排序,没有顺序 导致的数据混乱
     *
     * 回溯算法
     * 做每一轮的决策
     * 一旦失败,就会退到上一次解决结果上,再次进行处理
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur);
        return new ArrayList<>(res);
    }

    /**
     * nums：原数组
     * start：从下标start开始
     * cur：当前得到的列表
     */
    private void dfs(int[] nums, int start, List<Integer> cur) {
        // 当前位数时的cur直接加到res中，一开始是空集，后续每调用一层代表多一个位数的集合
        res.add(new ArrayList<>(cur));

        // 当前位从start开始（start以前的元素在前面的位中用过了），遍历到nums末尾
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            // 当前位取nums[i]，继续从i+1开始遍历下一位，避免重复
            dfs(nums, i + 1, cur);
            // 取消当前位的选择，下一轮循环重新选择一次当前位
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        List<List<Integer>> subsets = leetCode90.subsetsWithDup(new int[]{4,1,4,4,4});
        System.out.println(subsets);
    }


}
