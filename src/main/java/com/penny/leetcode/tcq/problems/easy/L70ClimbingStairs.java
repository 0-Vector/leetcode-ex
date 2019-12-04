package com.penny.leetcode.tcq.problems.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/12/04
 */
public class L70ClimbingStairs {
    /**
     * wayCount[i] = wayCount[i-1] + wayCount[i-2]
     * @param n 楼梯的阶数n
     * @return 方法的数量
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] wayCount = new int[n];
        wayCount[0] = 1;
        wayCount[1] = 2;
        for (int i = 2; i < n; i++) {
            wayCount[i] = wayCount[i-1] + wayCount[i-2];
        }
        return wayCount[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new L70ClimbingStairs().climbStairs(10));
    }
}
