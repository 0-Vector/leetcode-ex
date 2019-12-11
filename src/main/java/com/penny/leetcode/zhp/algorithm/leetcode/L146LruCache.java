package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
   public   static LinkedHashMap<Integer,Integer> list=null;
   public  static int length=0;
    public L146LruCache(int capacity) {
        list=new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>L146LruCache.length;
            }
        };
        length=capacity;
    }
    public int get(int key) {
      Integer val=list.get(key);
       if(val==null){
           return -1;
       }else{
           list.putIfAbsent(key,val);
           return val;
       }


    }
    public void put(int key, int value) {
        list.put(key,value);
    }

    public static void main(String[] args) {
        L146LruCache cache = new L146LruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4


    }


}