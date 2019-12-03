package com.penny.leetcode.zhp.algorithm.leetcode;

/**打家劫舍I
 * Creator:zhangpeng
 * Time:2019-11-27 9:27
 * Project: leetcode-ex
 * Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 示例 1:
 输入: [1,2,3,1]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
      偷窃到的最高金额 = 1 + 3 = 4 。
 示例 2:
 输入: [2,7,9,3,1]
 输出: 12
 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 */
public class L198PlunderHouses {

    public static int rob(int[] nums) {
        //计算金额的总和
        if(nums.length<=0){
            return 0;
        }
        int sum=0;
        int n=nums.length;
        for(int ele:nums){
           sum=sum+ele;
        }
        int [][] temp=new int[n][sum+1];
        //初始化
        temp[0][0]=-1;
        if(nums[0]<sum+1){
            temp[0][nums[0]]=1;
        }
        for(int i=1;i<n;i++){
            //选择第i号
            for(int j=0;j<=sum-nums[i];j++){
                if(temp[i-1][j]==-1 || temp[i-1][j]==2)
                    if(temp[i][j+nums[i]]!=0){
                        temp[i][j+nums[i]]=2;
                    }else{
                        temp[i][j+nums[i]]=1;
                    }
            }
            //不选择第i号
            for(int j=0;j<=sum;j++){
                if(temp[i-1][j]==1 || temp[i-1][j]==2) {
                    if (temp[i][j + nums[i]] != 0) {
                        temp[i][j + nums[i]] = 2;
                    } else {
                        temp[i][j + nums[i]] = -1;
                    }
                }
            }
        }
        for(int a=sum;a>=0 ;a--){
            if(temp[n-1][a]==-1 || temp[n-1][a]==1||temp[n-1][a]==2){
                return a;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int aa[]={1,1,1,2};
        System.out.println(L198PlunderHouses.rob(aa));
    }
}
