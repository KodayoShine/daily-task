package com.test.yg.algorithm;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class LeetCode83 {


    /**
     * 解题思路,当前节点和下一个节点进行判断,如果不同,表明可以将当前节点放在新链表上
     * 如果结果相同,则内部进行循环判断,找到下一个不同值
     * 在完成全部节点后,查看临时节点是否存在数据,如果存在表明也是独立的数据,加入到链表中
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode tl = listNode;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            ListNode next = tmpNode.next;
            if (next == null) {
                break;
            }
            if (tmpNode.val == next.val) {
                while (next != null && tmpNode.val == next.val) {
                    next = next.next;
                }
            }
            tl.next = new ListNode(tmpNode.val);
            tl = tl.next;

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
        LeetCode83 leetCode82 = new LeetCode83();
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
