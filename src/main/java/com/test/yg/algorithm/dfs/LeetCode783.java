package com.test.yg.algorithm.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode783 {

    static List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int cur = Math.abs(list.get(i) - list.get(i - 1));
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        System.out.println(root.val);
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
