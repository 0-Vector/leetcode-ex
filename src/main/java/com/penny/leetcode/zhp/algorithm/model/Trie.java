package com.penny.leetcode.zhp.algorithm.model;

/**
 * @author zhangpeng110
 * @create 2020/3/28 0028
 * @desc
 */
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public  void insertPositive (String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char temp = word.charAt(i);
            if(cur.children[temp-'a'] == null){
                cur.children[temp-'a'] = new TrieNode(temp);
            }
            cur = cur.children[temp - 'a'];
        }
    }

    public  int insertInverted(String word){
        TrieNode cur = root;
        boolean isNew = false;
        for(int i = word.length()-1;i>=0;i--){
            char temp = word.charAt(i);
            if(cur.children[temp-'a'] == null){
                isNew = true;
                cur.children[temp-'a'] = new TrieNode(temp);
            }
            cur = cur.children[temp - 'a'];
        }
        return isNew ? word.length()+1:0;
    }


}