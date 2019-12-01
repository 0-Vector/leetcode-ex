package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**最大子序和
 * @author zhangpeng110
 * @create 2019/11/30 0030
 * @desc
 *给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 题解:
这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
时间复杂度：O(n)O  (n)



     思考：如何打印出这个最大的子序列呢？

 *
 *
 */
public class L53MaxChildOrderTotal {


    public static int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len<=0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        int []temp=new int[len+len];
        //初始化
        temp[0]=nums[0];
        int max=nums[0];
        //循环求解
        for(int i=1;i<len;i++) {
            if(temp[i-1]>0){
                temp[i]= temp[i-1]+nums[i];
            }else{
                temp[i] = nums[i];
            }
            max=Math.max(max,temp[i]);
        }
       return max;
    }

    public static void main(String[] args) {
        int aa[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(L53MaxChildOrderTotal.maxSubArray(aa));

    }

}