package com.penny.leetcode.tcq.problems.easy;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/11 11:40
 */
public class L844BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Stack<Character> scs = new Stack<>();
        Stack<Character> tcs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc != '#') {
                scs.push(sc);
            } else if (!scs.empty()){
                scs.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            if (tc != '#') {
                tcs.push(tc);
            } else if(!tcs.empty()){
                tcs.pop();
            }
        }
        return scs.equals(tcs);
    }
}
