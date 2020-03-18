package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/17 0017
 * @desc
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
那么我们就认为你掌握了这个单词。
注意：每次拼写时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
示例 1：
输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释：
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
示例 2：
输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
提示：
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母
 *
 */
public class L1160FindWordsThatCanBeFormedByCharacters {


    public static int countCharacters(String[] words, String chars) {
          if(words == null || words.length <= 0){
              return 0;
          }
          int[] temp = new int[27];
          for(int i = 0; i < chars.length();i++){
              temp[chars.charAt(i)-'a'] ++;
          }
          int[] temps;
          StringBuilder sb = new StringBuilder();
          for(String word:words){
              temps = new int[27];
              boolean tmp = true;
              for(int j =0 ; j < word.length();j++){
                  temps[word.charAt(j)-'a'] ++;
              }
              for(int j =0 ; j < word.length();j++){
                  if(temps[word.charAt(j)-'a'] > temp[word.charAt(j)-'a']) {
                      tmp = false;
                      break;
                  }
              }
              if(tmp){
                  sb.append(word);
              }
            }
          return sb.toString().length();
    }

    public static void main(String[] args) {
       String[] words = {"cat","bt","hat","tree"};
       String  chars = "atach";
       System.out.println(L1160FindWordsThatCanBeFormedByCharacters.countCharacters(words,chars));

    }

}