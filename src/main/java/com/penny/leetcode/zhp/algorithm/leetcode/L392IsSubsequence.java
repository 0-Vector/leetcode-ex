package com.penny.leetcode.zhp.algorithm.leetcode;

/**判断子序列
 * @author zhangpeng110
 * @create 2019/12/10 0010
 * @desc
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

示例 2:
s = "axc", t = "ahbgdc"

返回 false.

后续挑战 :

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 */
public class L392IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()&& !t.isEmpty()){
            return true;
        }
        if(s.trim().equals(t.trim())){
            return true;
        }
        if(!s.isEmpty()&&t.isEmpty()){
            return false;
        }
       char ss[]=s.toCharArray();
       char tt[]=t.toCharArray();
        int i=0;
        for(char stemp:tt){
            if(ss[i]==stemp){
                i++;
            }
            if(i>ss.length-1){
                break;
            }
        }
        if(i>ss.length-1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
      String s="axc";
      String t="ahbgdc";
        System.out.println(L392IsSubsequence.isSubsequence(s,t));
    }

}