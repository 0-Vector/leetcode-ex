package com.penny.leetcode.zhp.algorithm.utils;

/**
 * @author zhangpeng110
 * @create 2019/11/23 0023
 * @desc
 */
public class PrintUtils {


    public  static void printTwoDimension(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + "  |\t");

            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t"); // "\t"是制表符
            }
            System.out.println();
        }
    }

}