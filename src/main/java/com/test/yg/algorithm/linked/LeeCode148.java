package com.test.yg.algorithm.linked;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class LeeCode148 {

    /**
     * 归并排序
     * 将链表通过快慢指针查询到中间位置
     * 然后从中间进行拆开
     * 然后递归的方式继续分割到最小数组(2个)
     *
     * 然后分别合并数组,根据大小数值进行排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextTmp = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(nextTmp);
        return merge(l, r);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode mergeNode = new ListNode(0);
        ListNode tmp = mergeNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                mergeNode.next = left;
                left = left.next;
            } else {
                mergeNode.next = right;
                right = right.next;
            }
            mergeNode = mergeNode.next;
        }
        // 查看left或者right哪个作为while退出条件
        mergeNode.next = left != null ? left : right;
        return tmp.next;
    }

    public class ListNode {
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
