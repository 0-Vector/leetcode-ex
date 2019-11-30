package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * 打家劫舍I
 *
 * @author zhangpeng110
 * @create 2019/11/26 0026
 * @desc 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *   题解:
 *     可以想到，到达第n个房子小偷能偷到的最大金额要么是n-2个房间的最大值+当前房间的金额，要不就是n-1房间的值
 *
 *
 *
 *
 */
public class L198HouseRobber {

    public static int rob(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int [] temp=new int[n+1];
        temp[0]=nums[0];
        int tempd=0;
        for(int i=1;i<n;i++){
            if(i==1){
                tempd=nums[i];
            }else{
                tempd=temp[i-2]+nums[i];
            }
            temp[i]=Math.max(temp[i-1],tempd);
        }
        return temp[n-1];
    }

    public static void main(String[] args) {
        //int dd[]={1,2,3,1};
        int dd[]={1,2};
        System.out.println(L198HouseRobber.rob(dd));


    }



}