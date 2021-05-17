package com.test.yg.algorithm.linked;

import lombok.Data;

/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode tmpListNode = null;
        while(head != null) {
            ListNode newListNode = new ListNode(head.val);
            newListNode.next = tmpListNode;
            tmpListNode = newListNode;
            head = head.next;
        }
        return tmpListNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        LeetCode206 leetCode2 = new LeetCode206();
        ListNode listNode = leetCode2.reverseList(listNode1);
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
