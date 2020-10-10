package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *  请使用迭代和递归分别实现
 *
 */
public class BinaryTreeInorderTraversal94 {


    public static void main(String[] args) {













    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> datas = new ArrayList<>();
        inorderTraversal(root,datas);
        return datas;
    }

    public void inorderTraversal(TreeNode root,List<Integer> datas) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left,datas);
        datas.add(root.val);
        inorderTraversal(root.right,datas);
    }



}
