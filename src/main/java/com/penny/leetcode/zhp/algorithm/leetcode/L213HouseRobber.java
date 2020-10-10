package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;

/**
 * 打家劫舍II
 * @author zhangpeng110
 * @create 2019/11/29 0029
 * @desc
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和
 * 最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
 题解:
 问题可以转化为，不偷第一间，与不偷最后一间的最大值
 *
 *
 */
public class L213HouseRobber {

    public static int rob(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //不偷第一件的情况
         return Math.max(L198HouseRobber.rob(Arrays.copyOfRange(nums,1,nums.length)),L198HouseRobber.rob(Arrays.copyOfRange(nums,0,nums.length-1)));
    }



    public static void main(String[] args) {
        int dd[]={1,2,3,1};
        //int dd[]={1,2};
        System.out.println(L213HouseRobber.rob(dd));
    }

}