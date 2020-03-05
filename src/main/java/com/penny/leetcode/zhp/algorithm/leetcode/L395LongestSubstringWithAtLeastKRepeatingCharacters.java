package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Creator:Administrator
 * Time:2020-03-04 16:54
 * Project: leetcode-ex
 * Description:
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

 示例 1:

 输入:
 s = "aaabb", k = 3

 输出:
 3

 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 示例 2:

 输入:
 s = "ababbc", k = 2

 输出:
 5

 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L395LongestSubstringWithAtLeastKRepeatingCharacters {



    public static int longestSubstringSub(String s, int k, int start, int end) {
        if(start > end) return 0;
        int[] count = new int[26];
        for(int i = start; i <= end; i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] > 0 && count[i] < k){
                int pos = s.indexOf((char)(i + 'a'), start);
                return Math.max(longestSubstringSub(s, k, start, pos - 1), longestSubstringSub(s, k, pos + 1, end));
            }
        }
        return end - start + 1;
    }


    public static   int longestSubstring(String s, int k) {
                return longestSubstringSub(s, k, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        String s = "ababbc";
        System.out.println(L395LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring(s,2));
    }


}
