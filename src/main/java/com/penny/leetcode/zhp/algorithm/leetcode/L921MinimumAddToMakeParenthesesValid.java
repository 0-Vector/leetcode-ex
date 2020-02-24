package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author zhangpeng110
 * @create 2020/2/14 0014
 * @desc
 */
public class L921MinimumAddToMakeParenthesesValid {
   static Stack<Character> stack;
    public static int minAddToMakeValid(String S) {
        stack = new Stack<>();
        char[] ss = S.toCharArray();
        int sum = 0;
        for(char s : ss){
            if(s == '('){
                stack.push(s);
                continue;
            }
            if(s == ')'){
                try {
                stack.pop();
                }catch (EmptyStackException e){
                    sum ++;
                }
            }

        }
       return sum + stack.size();
    }

    public static void main(String[] args) {
        String S = "()))((";
        System.out.println(L921MinimumAddToMakeParenthesesValid.minAddToMakeValid(S));
    }
}