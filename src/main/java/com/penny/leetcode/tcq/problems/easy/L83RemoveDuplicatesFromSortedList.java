package com.penny.leetcode.tcq.problems.easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/10/28 9:17
 */
public class L83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if(currentNode.val == currentNode.next.val) {
                if (currentNode.next.next != null) {
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode.next = null;
                }
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesV1(ListNode head) {
        recDeleteDuplicates(head);
        return head;
    }

    private void recDeleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        if (head.val != head.next.val) {
            recDeleteDuplicates(head.next);
            return;
        }
        if (head.next.next != null) {
            head.next = head.next.next;
            recDeleteDuplicates(head);
        } else {
            head.next = null;
        }
    }

    /**
     * @author 0-Vector
     * @date 2019/10/28 9:20
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
