package com.test.yg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LeetCode78 {

    /**
     * 遍历数组,对于数组的每一个整数,每一步都输出子集中所有子集添加这个整数,并生成新的子集
     * <p>
     * 第一步: 添加一个空集
     * 第二步: 访问第一个数字的时候, 对原本的子集追加当前数值 结果 [], [x]
     * 第三步: 再访问第二个数字的时候,在对原来的子集追加当前值y  结果 [] [x]    [y] [x, y]
     * 第四步: 再访问第三个数字的时候,在对原来的子集追加当前值z  结果 [] [x] [y] [x, y] [z] [x, z] [y, z] [x, y, z]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arrayList = new ArrayList<>();
        //先添加一个空的集合
        arrayList.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = arrayList.size();
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int j = 0; j < size; j++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> tmp = new ArrayList<>(arrayList.get(j));
                //然后在新的子集后面追加这个元素
                tmp.add(nums[i]);
                //把这个新的子集添加到集合中
                arrayList.add(tmp);
            }
        }
        return arrayList;
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯算法
     * 做每一轮的决策
     * 一旦失败,就会退到上一次解决结果上,再次进行处理
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        // 求不同位数的combination
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur);
        return res;
    }

    /**
     * nums：原数组
     * start：从下标start开始
     * cur：当前得到的列表
     */
    private void dfs(int[] nums, int start, List<Integer> cur) {
        System.out.println("final--" + cur);
        // 当前位数时的cur直接加到res中，一开始是空集，后续每调用一层代表多一个位数的集合
        res.add(new ArrayList<Integer>(cur));

        // 当前位从start开始（start以前的元素在前面的位中用过了），遍历到nums末尾
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            // 当前位取nums[i]，继续从i+1开始遍历下一位，避免重复
            dfs(nums, i + 1, cur);
            System.out.println("dfs last--" + cur);
            // 取消当前位的选择，下一轮循环重新选择一次当前位
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        leetCode78.subsets1(new int[]{1, 2, 3});
    }


}
