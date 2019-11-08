package com.penny.leetcode.problems.easy;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/8 10:07
 */
public class L242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            map.put(cs, map.getOrDefault(cs, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            if (map.get(ct) == null || map.get(ct) == 0) {
                return false;
            }
            map.put(ct, map.get(ct) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        L242ValidAnagram validAnagram = new L242ValidAnagram();
        System.out.println(validAnagram.isAnagram(s, t));
    }
}
