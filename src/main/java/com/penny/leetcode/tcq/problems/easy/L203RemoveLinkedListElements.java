package com.penny.leetcode.tcq.problems.easy;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author 0-Vector
 * @date 2019/10/31
 */
public class L203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (val == head.val) {
            return removeElements(head.next, val);
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            if (val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
