package com.penny.leetcode.tcq.problems.easy;

import java.util.HashMap;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/4 18:47
 */
public class L202HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        HashMap<Integer, Object> integerHashMap = new HashMap<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int t = n % 10;
                sum += t * t;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            } else if (integerHashMap.containsKey(sum)){
                return false;
            }
            integerHashMap.put(sum, null);
            n = sum;
        }
    }
}
