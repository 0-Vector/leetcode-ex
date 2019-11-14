package com.penny.leetcode.problems.easy;

import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * 本题答案保证唯一。
 *
 * 示例 1：
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 *
 * 示例 2：
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 *
 * 示例 3：
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *  
 * 提示：
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lambda
 * @date 2019/11/14 20:45
 */
public class L1209RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return null;
        }
        if (k == 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder(s);
        int count = 1;
        char preChar = builder.charAt(0);
        for (int i = 1; i < builder.length(); i++) {
            char currChar = builder.charAt(i);
            if (currChar != preChar) {
                preChar = currChar;
                count = 1;
            } else {
                if (++count == k) {
                    builder.delete(i-k+1, i+1);
                    if (i >= k + k - 2) {
                        i = i + 2 - k - k;
                    } else {
                        i = 0;
                    }
                    count = 1;
                    preChar = builder.charAt(i);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        L1209RemoveAllAdjacentDuplicatesInStringII duplicates = new L1209RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(duplicates.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
