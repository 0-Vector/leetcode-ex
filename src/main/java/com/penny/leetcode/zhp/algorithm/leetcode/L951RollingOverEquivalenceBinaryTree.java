package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**翻转等价二叉树
 * Creator:zhangpeng110
 * Time:2019-11-25 11:53
 * Project: leetcode-ex
 * Description:
 *
 *
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。

 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。

 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。

 示例：

 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 输出：true
 解释：We flipped at nodes with values 1, 3, and 5.

 提示：

 每棵树最多有 100 个节点。
 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。
 *
 *
 */
public class L951RollingOverEquivalenceBinaryTree {

    /**
     *
     思路
      如果二叉树 root1，root2 根节点值相等，那么只需要检查他们的孩子是不是相等就可以了。
     算法
     存在三种情况：
     如果 root1 或者 root2 是 null，那么只有在他们都为 null 的情况下这两个二叉数才等价。
     如果 root1，root2 的值不相等，那这两个二叉树的一定不等价。
     如果以上条件都不满足，也就是当 root1 和 root2 的值相等的情况下，需要继续判断 root1 的孩子节点是不是跟 root2 的孩子节点相当。因为可以做翻转操作，所以这里有两种情况需要去判断。
     *
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquivWithRecursion(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        return (flipEquivWithRecursion(root1.left, root2.left) && flipEquivWithRecursion(root1.right, root2.right) ||
                flipEquivWithRecursion(root1.left, root2.right) && flipEquivWithRecursion(root1.right, root2.left));
    }

    /**
     *
     让树中所有节点的左孩子都小于右孩子，如果当前不满足就翻转。我们把这种状态的二叉树称为 标准态。
     所有等价二叉树在转换成标准态后都是完全一样的。
      利用深度递归遍历操作
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquivWithTteration(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }



    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;

            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }
            vals.add(null);
        }
    }
/*
    public static void main(String[] args) {
        Integer a =10,b=10;
        System.out.println(a==b);

    }*/

}
