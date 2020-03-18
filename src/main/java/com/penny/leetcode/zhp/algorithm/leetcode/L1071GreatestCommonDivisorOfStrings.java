package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/12 0012
 * @desc
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
示例 1：
输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：
输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：
输入：str1 = "LEET", str2 = "CODE"
输出：""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class L1071GreatestCommonDivisorOfStrings {

    /**
     *  假设两个字符串具有公共子串，a ,那么按照题解，字符串1 具有m个a连接
     *  字符串B 具有n个a连接，那么m+n = n+m
     *  也就是说，str1 + str2 == str2 + str1 成立就一定有解，并且
     *
     *
     *
     *
     *
     */
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public static void main(String[] args) {
        String str = "ABSDF";
        System.out.println(str.substring(0,2));


    }
}