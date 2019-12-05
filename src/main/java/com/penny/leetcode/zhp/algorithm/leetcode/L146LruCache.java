package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**LRU缓存机制
  * @author zhangpeng110
  * @create 2019/12/5 0005
  * @desc
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
进阶:
你是否可以在 O(1) 时间复杂度内完成这两种操作？
示例:
示例:
LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
public class L146LruCache {

    Map<Integer,Integer> map=null;
    int [] data={};
    int length=0;
    int head=0;
    int tail=0;
    public L146LruCache(int capacity) {
        map=new HashMap<>();
        data=new int[capacity];
        length=capacity;
    }

    public int get(int key) {
     Integer i=map.get(key);
        if(i==null){
            return -1;
        }
     return data[i];
    }

    public void put(int key, int value) {
        if ((tail + 1) % length == head) {
            //满了

        }else{

           data[tail]=value;
           tail=(tail + 1) % length;
           map.put(key,tail);
        }
    }

    public static void main(String[] args) {

    }


}