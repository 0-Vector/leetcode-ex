package com.penny.leetcode.tcq.problems.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 1. How can we reuse a previously computed palindrome to compute a larger palindrome?
 * 2. If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
 * 3. Complexity based hint:
 *    If we use brute-force and check whether for every start and end position a substring is a palindrome
 *    we have O(n^2) start - end pairs and O(n) palindromic checks.
 *    Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lambda
 * @date 2019/12/1 10:57
 */
public class L5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        return null;
    }
}
