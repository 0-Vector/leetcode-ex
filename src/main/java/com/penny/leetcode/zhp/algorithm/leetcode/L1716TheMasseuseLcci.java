package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/24 0024
 * @desc
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动

 

示例 1：

输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
示例 2：

输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
示例 3：

输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
通过次数18,344提交次数34,308
 */
public class L1716TheMasseuseLcci {
    /**
     *   题解：
     *   如果我们用dp[i] 代表预约第i天所获得的最大时间，那么针对于[1,2,7,9,13,1]
     *   dp[0] = 1
     *   dp[1]=2
     *   dp[2]=8
     *   dp[3] = max(dp[1],dp[0])+9 这里说明一点，dp[i] 只能从dp[i-2]和dp[i-3]中选择最大值，不能从dp[i-4]中选择
     *   因为，dp[i]=dp[i-4]+A[i-2]+A[i] > dp[i-4]+A[i]
     *   故可以得到
     *   状态转换方程为：
     *   dp[i] = max(dp[i-2],dp[i-3])+Ai
     *   边界值
     *   dp[0] = A0;
     *   dp[1] = A1;
     *   dp[2] =A0+A2
     *
     *
     *
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        if(nums == null || nums.length<=0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length == 3){
            return Math.max(nums[0]+nums[2],nums[1]);
        }
       int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0]+nums[2];
        for(int i = 3;i <nums.length;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3])+nums[i];
        }
         return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }


    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(L1716TheMasseuseLcci.massage(nums));
    }

}