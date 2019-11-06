package com.penny.leetcode.problems.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author 0-Vector
 * @date 2019/11/5 10:44
 */
public class L204CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        boolean[] b = new boolean[n];
        for (int i = 4; i < n; i += 2) {
            b[i] = true;
        }
        for (int i = 3; i < n; i++) {
            if (b[i]) {
                continue;
            }
            count++;
            // 46341: Math.sqrt(Integer.MAX_VALUE)
            if (i < 46341) {
                int times = i * i;
                if (times < n) {
                    b[times] = true;
                    int step = i + i;
                    while (times < n - step) {
                        times += step;
                        b[times] = true;
                    }
                }
            }
        }
        return count;
    }
}
