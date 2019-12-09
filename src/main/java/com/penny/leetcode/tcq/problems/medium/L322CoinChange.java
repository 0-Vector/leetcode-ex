package com.penny.leetcode.tcq.problems.medium;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lambda
 * @date 2019/12/1 11:00
 */
public class L322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        for (int i = coins.length-1; i >= 0; i--) {
            if (coinChange(coins, amount - coins[i]) != -1) {
                return coinChange(coins, amount - coins[i]) + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {3,5};
        int amount = 9;
        System.out.println(new L322CoinChange().coinChange(coins, amount));
    }
}
