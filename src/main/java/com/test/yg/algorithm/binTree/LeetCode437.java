package com.test.yg.algorithm.binTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 *
 */
public class LeetCode437 {

    int count = 0;


    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> pre = new HashMap<>();

        // 前缀和为0的一条路径
        pre.put(0, 1);
        dfs(root, sum, pre, 0);
        return count;
    }

    public void dfs(TreeNode root, int sum, Map<Integer, Integer> pre, int cur) {
        if (root == null) {
            return;
        }

        // 更新前缀和
        cur += root.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        count += pre.getOrDefault(cur - sum, 0);
        pre.put(cur, pre.getOrDefault(cur, 0) + 1);


        // 递归左子树
        dfs(root.left, sum, pre, cur);
        // 递归右子树
        dfs(root.right, sum, pre, cur);

        // 回溯 ，恢复状态，去除当前节点的前缀和数量
        pre.put(cur, pre.getOrDefault(cur, 0) - 1);
    }
}
