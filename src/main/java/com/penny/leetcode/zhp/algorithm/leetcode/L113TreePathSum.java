package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangpeng110
 * @create 2019/11/23 0023
 * @desc 路径的总和
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class L113TreePathSum {
    List<List<Integer>> listf;
    Stack<Integer> temp;
    Integer sumPath;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        listf = new ArrayList<>(16);
        temp = new Stack<>();
        sumPath = sum;
        if (root == null) {
            return listf;
        }
        findPathSum(root);
        return listf;
    }

    private void findPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            temp.push(root.val);
            int sum = 0;
            for (Integer t : temp) {
                sum = sum + t;
            }
            if (sumPath.intValue() == sum) {
                Stack<Integer> stack = new Stack<Integer>();
                stack.addAll(temp);
                listf.add(stack);
            }
            return;
        }
        temp.push(root.val);
        if (root.left != null) {
            findPathSum(root.left);
            temp.pop();
        }
        if (root.right != null) {
            findPathSum(root.right);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);

        TreeNode root11 = new TreeNode(11);

        TreeNode root7 = new TreeNode(7);
        TreeNode root2 = new TreeNode(2);

        root11.left = root7;
        root11.right = root2;


        TreeNode root13 = new TreeNode(13);
        TreeNode root42 = new TreeNode(4);

        TreeNode root52 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        root42.left = root52;
        root42.right = root1;


        root4.left = root11;
        root8.left = root13;
        root8.right = root42;


        root5.left = root4;
        root5.right = root8;
        L113TreePathSum s = new L113TreePathSum();
        for (List<Integer> t : s.pathSum(root5, 22)) {
            for (Integer in : t) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }

}