package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangpeng110
 * @create 2020/2/8 0008
 * @desc
  实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
  调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 */
public class L173BinarySearchTreeIterator {
    Queue<Integer> queue ;
     public L173BinarySearchTreeIterator(TreeNode root) {
        queue = new LinkedList<>();
        this.insertData(root);
    }
    private void insertData(TreeNode root) {
        if(root == null){
            return;
        }
        insertData(root.left);
        queue.add(root.val);
        insertData(root.right);
    }
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {

    }

}