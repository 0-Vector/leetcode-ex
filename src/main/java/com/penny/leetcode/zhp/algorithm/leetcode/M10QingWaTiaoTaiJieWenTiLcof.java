package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/7 0007
 * @desc
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：

0 <= n <= 100
 */
public class M10QingWaTiaoTaiJieWenTiLcof {
    /**
     *
     * 最优子结构： 当青蛙跳到第n个台阶时，要么才n-2个台阶上来，要不从第n-1个台阶上来
     * 边界:  当n=1是只有一种走法，当n=2 是可以有两种走法
     * 状态转换方程: di[n] = di[n-1] +di[n-2]
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if(n <= 0){
            return 0;
          }
         if(n == 1){
             return 1;
         }
         if(n == 2){
            return 2;
          }
          int[] di = new int[n+1];
           di[1] = 1;
           di[2] = 2;
          for(int i = 3 ; i <= n;i++){
              di[i] = (di[i-1]+di[i-2]) %1000000007;
          }
          return di[n];
    }


    public static void main(String[] args) {
        System.out.println(M10QingWaTiaoTaiJieWenTiLcof.numWays(46));
    }
}