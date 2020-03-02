package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/2/29 0029
 * @desc
 */
public class L705DesignHashset {
    private byte[] objs;
    /** Initialize your data structure here. */
    public L705DesignHashset() {
        objs =new byte[1000001];
    }

    public void add(int key) {
        objs[key] = 1;
    }

    public void remove(int key) {
        objs[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(objs[key] ==0){
            return false;
        }
     return true;
    }






   /* *//** Initialize your data structure here. *//*
    private LinkedNode [] objs;
    private  int  length = 100;

    public L705DesignHashset() {
        objs = new LinkedNode[length];
    }

    public void add(int key) {
        int offset = key % length;
        if(objs[offset] == null){
            objs[offset] = new LinkedNode(null);
        }
        addNode(new LinkedNode(key),objs[offset]);
    }

    public void remove(int key) {
        int offset = key % length;
        if(objs[offset]!=null){
            reomveNode(new LinkedNode(key),objs[offset]);
        }
    }

    private void addNode(LinkedNode node,LinkedNode head){
        LinkedNode temp = head.next == null ?head:head.next;
        while (temp != null){
            if(temp.val == node.val) return;
            if(temp.next == null){
                break;
            }else{
                temp = temp.next;
            }
        }
        temp.next = node;
        node.pre = temp;
    }


    private void reomveNode(LinkedNode node,LinkedNode head){
        LinkedNode temp = head.next;
        while (temp != null){
            if(temp.val == node.val) break;
            temp = temp.next;
        }
        if(temp == null ){
            return;
        }
        if(temp.next ==null){
            temp.pre.next = null;
        }else {
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        }


    }


    *//** Returns true if this set contains the specified element *//*
    public boolean contains(int key) {
        int offset = key % length;
        LinkedNode temp = objs[offset]==null ?null:objs[offset].next;
        if(temp == null){
            return false;
        }else {
            while (temp !=null){
                if(temp.val == key){
                    return true;
                }
            }
        }
      return false;
    }

    class  LinkedNode {
        public Integer val;
        public LinkedNode pre;
        public LinkedNode next;
        public LinkedNode(Integer val) {
            this.val = val;
        }
    }*/
    public static void main(String[] args) {
        L705DesignHashset hashSet = new L705DesignHashset();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));   ;// 返回 true
        System.out.println( hashSet.contains(3)); // 返回 false (未找到)
        hashSet.add(2);
        System.out.println( hashSet.contains(2));// 返回 true
        hashSet.remove(2);
        System.out.println( hashSet.contains(2)); // 返回  false (已经被删除)
    }


    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */

}