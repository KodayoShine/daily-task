package com.test.yg.algorithm.binTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 */
public class LeetCode889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        // 先用map将后序的位置进行保存,方便后续递归中查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode dfs(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight, Map<Integer, Integer> map) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight) {
            return root;
        }

        // 前序左子树根节点
        int leftIndexPre = preLeft + 1;

        // 后序左子树根节点
        int leftIndexPost = map.get(pre[leftIndexPre]);

        root.left = dfs(pre, leftIndexPre, leftIndexPre + leftIndexPost - postLeft, post, postLeft, leftIndexPost, map);
        root.right = dfs(pre, leftIndexPre + leftIndexPost - postLeft + 1, preRight, post, leftIndexPost + 1, postRight - 1, map);
        return root;
    }

}
