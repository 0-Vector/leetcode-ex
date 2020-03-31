package com.penny.leetcode.zhp.algorithm.model;

/**
 * @author zhangpeng110
 * @create 2020/3/28 0028
 * @desc
 * trie 树
 *
 */
public class TrieNode {

    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char val) {
        this.val = val;
    }
}