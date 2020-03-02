package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

/**
 * @author zhangpeng110
 * @create 2020/2/29 0029
 * @desc
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。

（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
示例：
输入：[8,3,10,1,6,null,14,null,null,4,7,13]
输出：7
解释：
我们有大量的节点与其祖先的差值，其中一些如下：
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 */
public class L1026MaximumDifferenceBetweenNodeAndAncestor {

    /**
     *
     * @param root
     * @return
     * 思想：对二叉树进行深度优先遍历，并同时记录这个过程中的最大值和最小值，叶子节点时进行计算
     *
     *
     */
    private static int miff = 0;
    public static int maxAncestorDiff(TreeNode root) {
        miff = 0;
        dfs(root,root.val,root.val);
          return miff;
    }
    private static void dfs(TreeNode root,int max,int min){
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
       if(root.left == null && root.right == null){
           miff = Math.max(miff,max-min);
       }
        if(root.left != null){
            dfs(root.left,max,min);
        }
        if(root.right != null){
            dfs(root.right,max,min);
        }
    }
}