package com.penny.leetcode.tcq.problems.easy;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 提示：
 * 0 ≤ N ≤ 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lambda
 * @date 2019/11/27 23:18
 */
public class L509FibonacciNumber {

    /*
     * 动态规划算法二（带备忘的自顶向下）
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        return memoFib(n, memo);
    }

    private int memoFib(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 0) {
            return 0;
        }
        memo[n] = memoFib(n - 1, memo) + memoFib(n - 2, memo);
        return memo[n];
    }

    /*
     * 动态规划算法一（自底向上）
     */
    public int fibV2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1;
            int fn = 0;
            for (int i = 2; i <= n; i++) {
                fn = b + a;
                a = b;
                b = fn;
            }
            return fn;
        }
    }

    /*
     * 朴素递归算法
     */
    public int fibV1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int fib = new L509FibonacciNumber().fib(n);
        System.out.println(fib);
    }
}
