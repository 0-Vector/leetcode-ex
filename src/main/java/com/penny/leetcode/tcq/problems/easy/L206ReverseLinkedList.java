package com.penny.leetcode.tcq.problems.easy;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode remain = head.next;
        head.next = null;
        while (remain != null) {
            ListNode c = remain.next;
            remain.next = head;
            head = remain;
            remain = c;
        }
        return head;
    }

    public ListNode reverseListV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
