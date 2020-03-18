package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Stack;

/**
 * @author zhangpeng110
 * @create 2020/3/16 0016
 * @desc
 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:
输入："aabcccccaaa"
输出："a2b1c5a3"
示例2:
输入："abbccd"
输出："abbccd"
解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compress-string-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class M0106CompressSringLcci {
    public static String compressString(String S) {
        if(S ==null || S.length() <=0){
            return "";
        }
        if(S.length() <= 1){
            return S;
        }
        Stack<Character> stack = new Stack<>();
        char  temp;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length();i++){
            temp = S.charAt(i);
            if(stack.isEmpty()||stack.peek() == temp){
                stack.push(temp);
                continue;
            }
            sb.append(stack.peek()).append(stack.size());
            stack.removeAllElements();
            stack.push(temp);
        }
        sb.append(stack.peek()).append(stack.size());
      return S.length()>sb.toString().length() ?sb.toString():S;
    }

    public static void main(String[] args) {
        String S = "aabcccccaaa";
        System.out.println(M0106CompressSringLcci.compressString(S));
    }

}