package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * Creator:Administrator
 * Time:2019-11-26 10:44
 * Project: leetcode-ex
 * Description:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class L102LevelsSearchBinaryTree {

    Queue<TreeNode> queue;
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>(100);
        queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        List<Integer> midRes;
        TreeNode temp;
        int qlen;
        while (!queue.isEmpty()) {
            midRes = new ArrayList<>();
            qlen = queue.size();
            for (int i = 0; i < qlen; i++) {
                temp = queue.poll();
                midRes.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(midRes);
        }
        return res;
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
        L102LevelsSearchBinaryTree s = new L102LevelsSearchBinaryTree();
        for (List<Integer> t : s.levelOrder(root5)) {
            for (Integer in : t) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }
}
