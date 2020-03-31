package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.model.Trie;

import java.util.Arrays;

/**
 * @author zhangpeng110
 * @create 2020/3/28 0028
 * @desc
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 */
public class L820ShortEncodingOfWords {


    public int minimumLengthEncoding(String[] words) {
        if(words == null || words.length<=0) return 0;
        int sum = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for(String w:words){
          sum += trie.insertInverted(w);
        }
     return sum;
    }
    public static void main(String[] args) {

    }

}