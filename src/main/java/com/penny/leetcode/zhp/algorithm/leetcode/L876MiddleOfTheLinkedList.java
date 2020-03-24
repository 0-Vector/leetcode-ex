package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpeng110
 * @create 2020/3/23 0023
 * @desc
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

 

示例 1：

输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
示例 2：
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 */
public class L876MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
       Map<Integer,ListNode> temp = new HashMap();
       ListNode tmp = head.next;
        int i =  1;
       while(tmp != null){
          temp.put(i,tmp);
           i++;
           tmp = tmp.next;
        }
       return temp.get((i-2)/2+1);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}