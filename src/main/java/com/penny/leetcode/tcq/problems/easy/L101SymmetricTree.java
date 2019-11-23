package com.penny.leetcode.tcq.problems.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lambda
 * @date 2019/11/20 21:24
 */
public class L101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null && root.right != null && root.left.val == root.right.val) {
            queue.offer(root.left);
            queue.offer(root.right);
        } else{
            return root.left == null && root.right == null;
        }
        while (!queue.isEmpty()) {
            TreeNode leftFront = queue.poll();
            TreeNode rightFront = queue.poll();
            if (leftFront.left != null && rightFront.right != null && leftFront.left.val == rightFront.right.val) {
                queue.offer(leftFront.left);
                queue.offer(rightFront.right);
            } else if (leftFront.left != null || rightFront.right != null){
                return false;
            }
            if (leftFront.right != null && rightFront.left != null && leftFront.right.val == rightFront.left.val) {
                queue.offer(leftFront.right);
                queue.offer(rightFront.left);
            } else if (leftFront.right != null || rightFront.left != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetricV1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        if (root.left != null) {
            leftQueue.offer(root.left);
        }
        if (root.right != null) {
            rightQueue.offer(root.right);
        }
        while (leftQueue.size() == rightQueue.size()) {
            if (leftQueue.isEmpty()) {
                return true;
            }
            TreeNode leftFront = leftQueue.poll();
            TreeNode rightFront = rightQueue.poll();
            if (leftFront.val != rightFront.val) {
                return false;
            }
            if (leftFront.left != null ^ rightFront.right != null) {
                return false;
            } else if (leftFront.left != null){
                leftQueue.offer(leftFront.left);
                rightQueue.offer(rightFront.right);
            }
            if (leftFront.right != null ^ rightFront.left != null) {
                return false;
            } else if (leftFront.right != null) {
                leftQueue.offer(leftFront.right);
                rightQueue.offer(rightFront.left);
            }
        }
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new L101SymmetricTree().isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

}
