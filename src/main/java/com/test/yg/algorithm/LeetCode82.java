package com.test.yg.algorithm;

import lombok.val;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class LeetCode82 {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode tl = listNode;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            ListNode next = tmpNode.next;
            if (next == null) {
                break;
            }
            if (tmpNode.val != next.val) {
                tl.next = new ListNode(tmpNode.val);
                tl = tl.next;
            } else {
                while (next != null && tmpNode.val == next.val) {
                    next = next.next;
                }
            }
            tmpNode = next;
        }
        if(tmpNode != null){
            tl.next = new ListNode(tmpNode.val);
        }

        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
        LeetCode82 leetCode82 = new LeetCode82();
        ListNode listNode1 = leetCode82.deleteDuplicates(listNode);
        System.out.println(listNode1);
    }


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
