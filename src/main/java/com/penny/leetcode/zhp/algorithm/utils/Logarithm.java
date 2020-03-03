package com.penny.leetcode.zhp.algorithm.utils;

/**
 * Creator:Administrator
 * Time:2020-02-20 16:15
 * Project: leetcode-ex
 * Description:
 *     对数计算
 *
 */
public class Logarithm {
    public static  double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static double log2(double value) {
        return log(value, 2.0);
    }

    public static void main(String[] args) {
        /**
         * 0.998
         * 0.954
         * 0.985
         * 0
         */

        System.out.println(8d/17d*(3d/8d*Logarithm.log2(3d/8d)+5d/8d*Logarithm.log2(5d/8d)));
        System.out.println(7d/17d*(3d/7d*Logarithm.log2(3d/7d)+4d/7d*Logarithm.log2(4d/7d)));

    }



}
