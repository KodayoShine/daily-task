package com.test.yg.algorithm.binTree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 */
public class LeetCode0403 {

    List<ListNode> list = new ArrayList<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        dfs(tree, 0);
        return list.toArray(new ListNode[list.size()]);
    }

    /**
     * 根据深度和当前数组的长度相同时,
     * 就会创建一个对象,
     *
     *
     * @param root
     * @param deep
     */
    public void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }

        if (list.size() == deep) {
            list.add(deep, new ListNode(root.val));
        } else {
            ListNode head = list.get(deep);
            while (head.next != null) {
                head = head.next;
            }
            head.next = new ListNode(root.val);
        }
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }


    @Data
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
