package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.Stack;

/** 验证二叉搜索树
 * @author zhangpeng110
 * @create 2019/11/24 0024
 * @desc
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
2
/ \
1   3
输出: true
示例 2:

输入:
5
/ \
1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 */
public class L98SimilarityBinaryTree {
    Stack<Integer> stack=new Stack<>();
    boolean isOk=true;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        validBST(root);
        return isOk;
    }

    private void validBST(TreeNode root) {
        if(root==null){
            return;
        }
        validBST(root.left);
        if(!stack.isEmpty() && stack.peek()>=root.val){
            this.isOk=false;
            return;
        }else{
            stack.push(root.val);
        }
        validBST(root.right);
    }
    public static void main(String[] args) {

    }


    public  boolean isValidBST2(TreeNode root){
        boolean isok=true;
        if(root==null){
            return true;
        }else{
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> temp = new Stack<>();
            while (root!=null||!stack.isEmpty()){
                while (root!=null){// 一路向左把沿途结点压入栈
                    stack.push(root);
                    root = root.left;
                }
                if(!stack.isEmpty()){
                    root = stack.pop();// 弹出栈
                    if(!temp.isEmpty()&&temp.peek()>=root.val){
                        isok=false;
                        break;
                    }else{
                        temp.push(root.val);
                    }
                    root = root.right;// 转向右节点
                }
            }
            return isok;
        }
    }


}