package com.penny.leetcode.zhp.algorithm.leetcode;

/**使用最小花费爬楼梯
 * Creator:Administrator
 * Time:2019-12-02 19:43
 * Project: leetcode-ex
 * Description:
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 示例 1:
 输入: cost = [10, 15, 20]
 f(n)=min(f(n-1),f(n-2))
 输出: 15
 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
  示例 2:
 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 输出: 6
 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 注意：
 cost 的长度将会在 [2, 1000]。
 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class L746MinCostClimbingStairs {
    /**
     * 题解:
     * 最优子结构：  到达第n和台阶的最小花费等于到达第n-2个台阶和到达第n-1个台阶的最小值，
     * 边界：当n=0 时最小的代价就是0
     *       当n=1 时最小代价是cost[1]
     * 状态转换方程：
     *              f(n)=min(f(n-2)+,f(n-1)) +cost[n]  n>=0
     * 特殊点：当到达第n层时，由于不会再向上爬，所以不会花费
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        int dd[]={10,15,20};
        System.out.println(L746MinCostClimbingStairs.minCostClimbingStairs(dd));
    }

}
