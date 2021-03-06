package com.penny.leetcode.tcq.problems.easy;

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
    private int longestUnivaluePath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        univaluePathOneSide(root);
        return longestUnivaluePath;
    }

    private int univaluePathOneSide(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftUnivaluePathOneSide = univaluePathOneSide(root.left);
        int rightUnivaluePathOneSide = univaluePathOneSide(root.right);
        if (root.left != null) {
            if (root.val == root.left.val) {
                leftUnivaluePathOneSide++;
            } else {
                leftUnivaluePathOneSide = 0;
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val) {
                rightUnivaluePathOneSide++;
            } else {
                rightUnivaluePathOneSide = 0;
            }
        }
//        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            longestUnivaluePath = Math.max(longestUnivaluePath, leftUnivaluePathOneSide + rightUnivaluePathOneSide);
//        }
        return Math.max(leftUnivaluePathOneSide, rightUnivaluePathOneSide);
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
