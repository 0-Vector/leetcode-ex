package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author zhangpeng110
 * @create 2019/12/1 0001
 * @desc
 * 给定不同面额的硬币 coins 和一个总金额 amount
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1
说明: 动态规划求解:
d(i)=min{ d(i-1)+1,d(i-vj)+1 }，其中i-vj >=0
 其中vj为给出的纸币面额
 *
 */
public class L322CoinChange {


    public static int coinChange(int[] coins, int amount) {
        int  len=coins.length;
        if(len==0){
            return -1;
        }

        int temp[]=new int[amount+1];
        Arrays.fill(temp, amount+1);
        temp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if (coins[j] <= i) {
                    temp[i] = Math.min(temp[i], temp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(temp);
        return temp[amount]>amount|| temp[amount] <0 ?-1:temp[amount];
    }

    public static void main(String[] args) {
      //coins = [1, 2, 5], amount = 11  [2]
       // 3
        int coins[]={1,2,5};
        int amount=11;
       /* int coins[]={2};
        int amount=3;*/
        System.out.println(L322CoinChange.coinChange(coins,amount));
    }

}