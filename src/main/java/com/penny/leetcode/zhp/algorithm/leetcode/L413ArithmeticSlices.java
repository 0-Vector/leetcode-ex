package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Creator:Administrator
 * Time:2020-01-19 15:50
 * Project: leetcode-ex
 * Description:
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * 1, 1, 2, 5, 7 
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * 示例:
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]
 * 题解：
 */
public class L413ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int p = 0;
        int q = A.length;
        int sum = 0;
        if (!(p + 1 < q)) {
            return 0;
        }
        while (p+1 < q) {
            if( isArithmeticSlices(A,p,q) ){
                 sum ++;
            }
        }
        return sum;
    }

    private static boolean isArithmeticSlices(int[] a, int p, int q) {
        Set<Integer> sets=new HashSet<>();
        while ( p < q){
            sets.add(( a[p+1]-a[p] ));
        }
        if( sets.size() ==1 ){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(L413ArithmeticSlices.numberOfArithmeticSlices(a));
    }
}
