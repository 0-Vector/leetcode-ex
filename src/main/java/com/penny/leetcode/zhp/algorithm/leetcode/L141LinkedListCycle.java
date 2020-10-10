package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 *
 给定一个链表，判断链表中是否有环。

 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

 如果链表中存在环，则返回 true 。 否则，返回 false 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-cycle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 题解：
  利用龟兔赛跑算法，一个慢指针，一个快指针，如果相遇则说明有环，否则没有

 */
public class L141LinkedListCycle {


    public static void main(String[] args) {




    }


    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public boolean hasCycle(L147InsertionSortList.ListNode head) {
        int pos = -2;
        L147InsertionSortList.ListNode fast = head;
        L147InsertionSortList.ListNode slow = head;
        if(head == null ){
            return false;
        }
        while(true)
        {
            fast = fast.next==null?null:fast.next.next;
            slow = slow.next==null?null:slow.next;
            if( fast ==null || slow ==null ){
                pos = -1;
                break;
            }
            if(fast == slow){
                pos = slow.val;
                break;
            }
        }
        return pos==-1?false:true;
    }

}
