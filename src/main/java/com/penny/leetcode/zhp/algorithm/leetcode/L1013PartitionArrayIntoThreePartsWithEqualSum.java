package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/11 0011
 * @desc

给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 
true，否则返回 false。
形式上，如果可以找出索引 i+1 < j 且满足 
(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 
就可以将数组三等分。
示例 1：
输出：[0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
示例 2：
输入：[0,2,1,-6,6,7,9,-1,2,0,1]
输出：false
示例 3：
输入：[3,3,6,5,-2,2,5,1,-9,4]
输出：true
解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
提示：
3 <= A.length <= 50000
-10^4 <= A[i] <= 10^4
 */
public class L1013PartitionArrayIntoThreePartsWithEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        if(A == null || A.length <= 2) return false;
        int sum = 0;
        for(int a: A){
            sum += a;
        }
        if(sum % 3 !=0 ) return false;
        int temp = sum / 3;
        int sumOne = 0 ;
        for(int i =0 ; i < A.length;i++){
            sumOne = sumOne + A[i];
            int sumTwo = 0;
            int sumThree = 0;
            int j = i + 1;
            if(sumOne == temp){
                while (j < A.length){
                    sumTwo = sumTwo + A[j];
                    j ++;
                    if(sumTwo == temp) break;
                }
                if(j == A.length){
                    continue;
                }
                while ( j < A.length){
                    sumThree = sumThree + A[j];
                    j++;
                }
                if(sumThree == temp) return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {0,2,1,1,2};
        System.out.println(L1013PartitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(array));
    }
}