package com.penny.leetcode.tcq.problems.medium;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lambda
 * @date 2019/11/24 18:49
 */
public class L98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return isValidBST(root.right) && root.val < getMin(root.right);
        } else if (root.right == null) {
            return isValidBST(root.left) && root.val > getMax(root.left);
        } else {
            return isValidBST(root.left) && isValidBST(root.right) && root.val > getMax(root.left) && root.val < getMin(root.right);
        }
    }

    private int getMin(TreeNode root) {
        int min = root.val;
        if (root.left != null) {
            int leftMin = getMin(root.left);
            if (min > leftMin) {
                min = leftMin;
            }
        }
        if (root.right != null) {
            int rightMin = getMin(root.right);
            if (min > rightMin) {
                min = rightMin;
            }
        }
        return min;
    }

    private int getMax(TreeNode root) {
        int max = root.val;
        if (root.left != null) {
            int leftMax = getMax(root.left);
            if (max < leftMax) {
                max = leftMax;
            }
        }
        if (root.right != null) {
            int rightMax = getMax(root.right);
            if (max < rightMax) {
                max = rightMax;
            }
        }
        return max;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
