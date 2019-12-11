package com.penny.leetcode.tcq.problems.medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Currency;

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
    /**
     * 动态规划
     * @param coins 硬币面额
     * @param amount 总金额
     * @return 最少硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] coinNum = new int[amount+1];
        for (int i = 1; i < coinNum.length; i++) {
            coinNum[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0 && coinNum[i - coin] != -1) {
                    coinNum[i] = Integer.min(coinNum[i], coinNum[i - coin] + 1);
                }
            }
            if (coinNum[i] == amount + 1) {
                coinNum[i] = -1;
            }
        }
        return coinNum[amount];
    }

    /**
     * 朴素递归
     * @param coins 硬币面额
     * @param amount 总金额
     * @return 最少硬币数
     */
    public int coinChangeV1(int[] coins, int amount) {
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
//        int[] coins = {3,5};
//        int amount = 9;
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(new L322CoinChange().coinChange(coins, amount));
    }
}
