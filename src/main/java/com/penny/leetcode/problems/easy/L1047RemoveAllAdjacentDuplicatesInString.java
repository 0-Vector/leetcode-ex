package com.penny.leetcode.problems.easy;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/12 12:29
 */
public class L1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (builder.charAt(builder.length() - 1) != currChar || builder.length() == 0) {
                builder.append(currChar);
            } else {
                while (builder.charAt(builder.length() - 1) == currChar) {
                    builder.deleteCharAt(builder.length() - 1);
                    if (builder.length() == 0) {
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }

    public String removeDuplicatesV1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (stack.empty() || !stack.peek().equals(currChar)) {
                stack.push(currChar);
            } else {
                while (stack.peek().equals(currChar)) {
                    stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        L1047RemoveAllAdjacentDuplicatesInString duplicates = new L1047RemoveAllAdjacentDuplicatesInString();
        System.out.println(duplicates.removeDuplicates("babbabac"));
    }
}
