package com.test.yg.algorithm;

import lombok.Data;
import lombok.val;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *  
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(l1.val + l2.val);
        ListNode tmpListNode = listNode;
        // int carry = 0;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmpListNode.val / 10;
            tmpListNode.val = tmpListNode.val % 10;
            tmpListNode.next = new ListNode(sum);
            tmpListNode = tmpListNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode ll = l1 == null ? l2 : l1;
        while (ll != null) {
            int sum = ll.val + tmpListNode.val / 10;
            tmpListNode.val = tmpListNode.val % 10;
            tmpListNode.next = new ListNode(sum);
            tmpListNode = tmpListNode.next;
            ll = ll.next;
        }

        if(tmpListNode.val >= 10) {
            tmpListNode.next = new ListNode(tmpListNode.val / 10);
            tmpListNode.val = tmpListNode.val % 10;
        }

        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(5);

        LeetCode2 leetCode2 = new LeetCode2();
        ListNode listNode = leetCode2.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);

    }

    @Data
    static class ListNode {
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
