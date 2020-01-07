package com.penny.leetcode.zhp.algorithm.leetcode;

/**对链表进行插入排序
 * @author zhangpeng110
 * @create 2019/12/13 0013
 * @desc
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *      for(int index = 1; index<length; index++){//外层向右的index，即作为比较对象的数据的index
int temp = array[index];//用作比较的数据
int leftindex = index-1;
while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
array[leftindex+1] = array[leftindex];
leftindex--;
}
array[leftindex+1] = temp;//把temp放到空位上
}

 *
 *
 */
public class L147InsertionSortList {

    public ListNode insertionSortList(ListNode head){
        // 创建 h 节点，用于遍历链表
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        ListNode lat;

        while (cur != null) {
            lat = cur.next; // 记录下一个要插入排序的值

            if (lat != null && lat.val < cur.val) { // 只有 cur.next 比 cur 小才需要向前寻找插入点
                // 寻找插入点，从 pre 开始遍历 （每次都是头节点 h 开始向后遍历，因为单向链表是无法从后往前遍）
                while (pre.next != null && pre.next.val < lat.val) { // 如果当前节点的值小于要插入排序的值
                    pre = pre.next; // 继续向后移动
                }

                // 找到要插入的位置，此时 pre 节点后面的位置就是 lat 要插入的位置
                // 交换 pre 跟 lat 节点需要一个 temp 节点来临时保存下插入位置 node 后 next
                ListNode tmp = pre.next;
                // 在 pre 节点后面插入
                pre.next = lat;
                // 此时 cur 节点还是 pre 所在的节点，所以其 next 要指向插入节点 lat 指向的 next
                cur.next = lat.next;
                // 插入let节点后，把记录的原先插入位置后续的 next 节点传给它
                lat.next = tmp;
                // 由于每次都是从前往后找插入位置，但是单向链表是无法从后往前遍历，所以需要每次插入完成后要让 pre 复位
                pre = h;
            } else {
                // 都这直接把 cur 指针指向到下一个
                cur = lat;
            }
        }

        return h.next;
    }
    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
    }
}