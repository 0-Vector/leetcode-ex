package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Creator:Administrator
 * Time:2020-02-19 19:09
 * Project: leetcode-ex
 * Description:
 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 提示：
 给定的两颗树可能会有 1 到 100 个结点。
 */
public class L872LeafSimilarTrees {

    /**
     * 中序遍历方式，利用递归
     * @param root1
     * @param root2
     * @return
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(inorderTraversal(root1).equals(inorderTraversal(root2))){
            return true;
        }
      return false;
    }
    public static String inorderTraversal(TreeNode root){
      StringBuilder sb = new StringBuilder();
      if(root == null){
          return null;
      }
      Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root = root.left;
      while (!stack.isEmpty() || root !=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
             }
          if (!stack.isEmpty()) {
              TreeNode node = stack.pop();
              if(node.left == null && node.right == null ){
                  sb.append(node.val);
              }
              root = node.right;
          }
        }
        return sb.toString();

    }
    public static void main(String[] args) {

    }


}
