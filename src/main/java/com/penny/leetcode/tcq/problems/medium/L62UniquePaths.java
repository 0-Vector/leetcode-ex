package com.penny.leetcode.tcq.problems.medium;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * S * - * - * -
 * * - * - * - *
 * - * - * - * T
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/12/11
 */
public class L62UniquePaths {
    /**
     * 动态规划（自底向上）
     * @param m 行数
     * @param n 列数
     * @return 总路径数
     */
    public int uniquePaths(int m, int n) {

        return 0;
    }

    /**
     * 动态规划（自底向上）
     * @param m 行数
     * @param n 列数
     * @return 总路径数
     */
    public int uniquePathsV1(int m, int n) {
        int[][] steps = new int[m][n];
        steps[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    steps[i][j] += steps[i - 1][j];
                }
                if (j > 0) {
                    steps[i][j] += steps[i][j - 1];
                }
            }
        }
        return steps[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new L62UniquePaths().uniquePaths(7, 3));
    }
}
