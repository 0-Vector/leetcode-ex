package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.TreeNode;

import java.util.Map;

/**打家劫舍
 * Creator:Administrator
 * Time:2019-11-26 16:06
 * Project: leetcode-ex
 * Description:
 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

 示例 1:

 输入: [3,2,3,null,3,null,1]

   3
  / \
 2   3
  \   \
  3   1

 输出: 7
 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 示例 2:

 输入: [3,4,5,1,3,null,1]

      3
     / \
    4   5
   / \   \
  1   3   1

 输出: 9
 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9
   题解:
     问题转化为:
 4个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，
 就当做当前节点能偷的最大钱数
 */
public class L337HouseRobber {
    /**
     * 法1，递归法
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return root.val;
        }
        //爷爷节点和四个孙子节点可以偷盗的钱
        int money=root.val;
        if(root.left!=null){
            money+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left)+rob(root.right.right);
        }
      return  Math.max(money,rob(root.left)+rob(root.right));
    }

    /**
     *
     * @param root
     * @return
     */
    public int rob1(TreeNode root, Map<TreeNode,Integer> map) {
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return root.val;
        }
        if(map.get(root)!=null){
            map.get(root);
        }
        //爷爷节点和四个孙子节点可以偷盗的钱
        int money=root.val;
        if(root.left!=null){
            money+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left)+rob(root.right.right);
        }
        int res= Math.max(money,rob(root.left)+rob(root.right));
        map.put(root,res);
        return res;
    }


    /**
     *动态规划
     * @param root
     * @return
     * 解: 每个节点能偷到的最大值有两种情况
     *  当前节点选择不偷
     *    总的金额=左孩子能偷到的最大钱数+右孩子能偷到最大钱数
     *
     *
     *  当前节点选择偷
     *    总的金额=左孩子选择不偷得到的最大钱数+右孩子选择不偷得到最大钱数
     *
     *    递推公式如下（int[0]选择偷，int[1]选择不偷）：
     *    sum=Math.max(root.val+rob(root.left)[0]+rob(root.right)[0],Math.max(rob(root.left)[0],rob(root.left)[1])+Math.max(rob(root.right)[0],rob(root.right)[1]))
     *
     *
     *
     *
     *
     *
     */
    public int rob2(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
       int[] res=robValue(root);
       return Math.max(res[0],res[1]);
    }

    private int[] robValue(TreeNode root) {
        if(root==null) return  new int[2];
        int res[]=new int[2];
        int[] left=robValue(root.left);
        int[] right=robValue((root.right));
        res[0]=root.val+left[0]+right[1];
        res[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }
}
