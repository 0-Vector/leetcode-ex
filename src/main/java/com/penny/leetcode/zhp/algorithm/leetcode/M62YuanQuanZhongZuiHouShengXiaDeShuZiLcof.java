package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhangpeng110
 * @create 2020/3/30 0030
 * @desc
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

示例 1：
输入: n = 5, m = 3
输出: 3
示例 2：
输入: n = 10, m = 17
输出: 2
 *
 *
 */
public class M62YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(M62YuanQuanZhongZuiHouShengXiaDeShuZiLcof.lastRemaining(5,3));
    }
}