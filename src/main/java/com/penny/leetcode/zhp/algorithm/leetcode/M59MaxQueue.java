package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangpeng110
 * @create 2020/3/7 0007
 * @desc
 *
 */
public class M59MaxQueue {
    private Queue<Integer>  queue;
    private Deque<Integer> deque;
    public M59MaxQueue() {
        queue = new LinkedList<>();
        deque =  new LinkedList<>();
    }
    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return deque.peekFirst();
    }
    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
        queue.add(value);
    }
    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int ans = queue.peek();
        if (ans == deque.peekFirst()) {
            deque.pollFirst();
        }
        queue.poll();
        return ans;
    }

    /**
     *      *
     "MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * @param args
     */
    public static void main(String[] args) {
        M59MaxQueue queue = new M59MaxQueue();
        queue.max_value();
        queue.push_back(1);
        queue.push_back(2);
        queue.max_value();
        queue.pop_front();
        queue.max_value();
    }
}