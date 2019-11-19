package com.penny.leetcode.problems.easy;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lambda
 * @date 2019/11/19 21:59
 */
public class L687LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left == null) {
            return root.val == root.right.val ? longestUnivaluePath(root.right) + 1 : longestUnivaluePath(root.right);
        }
        if (root.right == null) {
            return root.val == root.left.val ? longestUnivaluePath(root.left) + 1 : longestUnivaluePath(root.left);
        }
        int leftUnivaluePath = longestUnivaluePath(root.left);
        int rightUnivaluePath = longestUnivaluePath(root.right);
        if (root.val == root.left.val && root.val == root.right.val) {
            return leftUnivaluePath + 2 + rightUnivaluePath;
        } else if (root.val == root.left.val) {
            return leftUnivaluePath + 1 > rightUnivaluePath ? leftUnivaluePath + 1 : rightUnivaluePath;
        } else if (root.val == root.right.val) {
            return rightUnivaluePath + 1 > leftUnivaluePath ? rightUnivaluePath + 1 : leftUnivaluePath;
        } else {
            return leftUnivaluePath > rightUnivaluePath ? leftUnivaluePath : rightUnivaluePath;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
