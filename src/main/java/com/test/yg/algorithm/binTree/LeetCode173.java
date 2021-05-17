package com.test.yg.algorithm.binTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 */
public class LeetCode173 {

    /**
     * 解题思路:
     * 采用中序遍历的方式,将节点的数值都存在集合中
     * 中序遍历:
     * 先左 再中 最后右
     *
     */
    static class BSTIterator {

        List<Integer> lists;
        int index;

        public BSTIterator(TreeNode root) {
            this.lists = new ArrayList<>();
            this.index = 0;
            recursion(root);
        }

        public int next() {
            return lists.get(index++);
        }

        public boolean hasNext() {
            return lists.size() != index && lists.get(index) != null;
        }

        private void recursion(TreeNode root) {
            if (root != null) {
                recursion(root.left);
                lists.add(root.val);
                recursion(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        BSTIterator bstIterator = new BSTIterator(treeNode);
        assert bstIterator.next() == 3;
        assert bstIterator.next() == 7;
        assert bstIterator.next() == 15;
        assert !bstIterator.hasNext();
    }


    public static class TreeNode {
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
