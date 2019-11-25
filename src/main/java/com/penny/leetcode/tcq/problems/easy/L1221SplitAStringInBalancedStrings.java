package com.penny.leetcode.tcq.problems.easy;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 *
 * 示例 2：
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 *
 * 示例 3：
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/11/25 08:49
 */
public class L1221SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int count = 0, diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                diffCount++;
            } else {
                diffCount--;
            }
            if (diffCount == 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "RRRLLL";
        System.out.println(new L1221SplitAStringInBalancedStrings().balancedStringSplit(s));
    }
}
