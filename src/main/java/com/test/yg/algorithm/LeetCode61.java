package com.test.yg.algorithm;

import lombok.Data;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class LeetCode61 {


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        // 最后一个点
        ListNode lastNode = head;
        int size = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            size++;
        }
        // 计算实际移动位置
        k = size - k % size;

        lastNode.next = head;

        int i = 0;
        while(lastNode != null) {
            if(i == k) {
                break;
            }
            lastNode = lastNode.next;
            i++;
        }

        head = lastNode.next;
        lastNode.next = null;
        return head;
    }


    public static void main(String[] args) {
        LeetCode61.ListNode listNode = new LeetCode61.ListNode(1);
        listNode.next = new LeetCode61.ListNode(2);
        listNode.next.next = new LeetCode61.ListNode(3);
        listNode.next.next.next = new LeetCode61.ListNode(4);
        listNode.next.next.next.next = new LeetCode61.ListNode(5);
        /*listNode.next.next.next.next.next = new LeetCode61.ListNode(3);*/

        LeetCode61 leetCode61 = new LeetCode61();
        ListNode listNode1 = leetCode61.rotateRight(listNode, 8);
        System.out.println(listNode1);
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
