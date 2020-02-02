package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zhangpeng110
 * @create 2020/1/31 0031
 * @desc
 */
public class L455AssignCookies {

    /**
     *
     * @param g 孩子的个数
     * @param s 糖的个数
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        if(g.length <= 0 || s.length <= 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int i=0 ,j = 0;
        while(i < g.length && j < s.length){
            if(s[j]>=g[i]){
                sum = sum+1;
                i++;
            }
             j++;

        }
        return sum;
     }

    /**
     * [10,9,8,7]
     [5,6,7,8]
     * @param args
     */
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int [] s = {5,6,7,8};
        System.out.println(L455AssignCookies.findContentChildren(g,s));

    }

}