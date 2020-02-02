package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/2/2 0002
 * @desc
 */
public class L1217PlayWithChips {
    public static int minCostToMoveChips(int[] chips) {
        int even=0;
        int odd=0;
        for(int ele:chips){
         if(ele % 2==0){
             even++;
         }else{
             odd++;
         }
        }
        return Math.min(even,odd);
    }

}