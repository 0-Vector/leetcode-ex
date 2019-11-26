package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**二叉树的中序遍历
 * Creator:Administrator
 * Time:2019-11-26 9:48
 * Project: leetcode-ex
 * Description:
 * 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3
 输出: [1,3,2]
 */
public class L94BinaryTreeMiddleSearch {
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list=new ArrayList<>();
        //MiddleSearchBinaryTree(root);
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()|| root!=null){
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                list.add(stack.peek().val);
                root=stack.pop().right;
                }
         }
        return list;
    }
    public  void MiddleSearchBinaryTree(TreeNode root){
      if(root==null){
          return;
      }
      MiddleSearchBinaryTree(root.left);
      list.add(root.val);
      MiddleSearchBinaryTree(root.right);
    }
    public static void main(String[] args) {

    }

}
