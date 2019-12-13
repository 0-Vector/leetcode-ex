package com.penny.leetcode.tcq.problems.medium;

import java.util.List;

/**
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/12/13 11:37
 */
public class L147InsertionSortList {

    /**
     * 链表原地插入排序
     * @param head 头指针
     * @return 排序后的链表
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            ListNode nextNode = currNode.next;
            if (currNode.val > nextNode.val) {
                currNode.next = nextNode.next;
                if (nextNode.val < head.val) {
                    nextNode.next = head;
                    head = nextNode;
                } else {
                    insert(head, nextNode);
                }
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }

    /**
     * 插入元素
     * @param head 头指针
     * @param insertNode 要插入的元素
     */
    private void insert(ListNode head, ListNode insertNode) {
        ListNode currNode = head;
        while (currNode.next.val < insertNode.val) {
            currNode = currNode.next;
        }
        insertNode.next = currNode.next;
        currNode.next = insertNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] headArr = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(headArr[0]);
        ListNode curr = head;
        for (int i = 1; i < headArr.length; i++) {
            ListNode next = new ListNode(headArr[i]);
            curr.next = next;
            curr = curr.next;
        }
        System.out.println(new L147InsertionSortList().insertionSortList(head));
    }
}
