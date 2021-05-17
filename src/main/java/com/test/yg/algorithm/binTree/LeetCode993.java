package com.test.yg.algorithm.binTree;

import com.test.yg.algorithm.binTree.TreeNode;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 */
public class LeetCode993 {

    TreeNode xParent = null;
    TreeNode yParent = null;

    int xLevel = 0;
    int yLevel = 0;

    /**
     * 通过递归的方式,搜索出每个值对应的深度和父类
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return xParent != yParent && xLevel == yLevel;
    }

    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xLevel = level;
            xParent = parent;
        } else if (root.val == y) {
            yLevel = level;
            yParent = parent;
        }

        dfs(root.right, level + 1, root, x, y);
        dfs(root.left, level + 1, root, x, y);
    }


}
