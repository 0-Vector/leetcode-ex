package com.penny.leetcode.tcq.problems.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/15 12:23
 */
public class L1190ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
//        if (s == null || s.length() == 0) {
//            return null;
//        }
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                while (stack.peek() != ')') {
                    deque.add(stack.pop());
                }
                stack.pop();
                while (!deque.isEmpty()) {
                    stack.push(deque.poll());
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "(abcd)";
        L1190ReverseSubstringsBetweenEachPairOfParentheses pair = new L1190ReverseSubstringsBetweenEachPairOfParentheses();
        System.out.println(pair.reverseParentheses(s));
    }
}
