package com.test.yg.algorithm;

import lombok.Data;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class LeetCode83 {


    /**
     * 解题思路:
     * 查看当前节点和下一个节点的数值是否相同
     * 如果相同,则循环向下查找到不同的链表
     * 再将当前链表的next指向不同的链表上
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.val == tmp.next.val){
                ListNode next = tmp.next;
                while(next.next != null && next.val == next.next.val){
                    next = next.next;
                }
                tmp.next = next.next;
            }
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
        LeetCode83 leetCode82 = new LeetCode83();
        ListNode listNode1 = leetCode82.deleteDuplicates(listNode);
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
