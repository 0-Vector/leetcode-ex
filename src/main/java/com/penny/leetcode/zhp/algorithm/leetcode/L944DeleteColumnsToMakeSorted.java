package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/2/2 0002
 * @desc
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
比如，有 A = ["abcdef", "uvwxyz"]，
要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 */
public class L944DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] A) {
        if(A==null || A.length<=0){
            return 0;
        }
        int  ans=0;
        int singleLength=A[0].length();
        int al=A.length;
        for(int c=0;c<singleLength;c++){
            for(int r=0;r<al-1;r++) {
                if(A[r].charAt(c)>A[r+1].charAt(c)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String [] A={"cba", "daf", "ghi"};
        System.out.println(L944DeleteColumnsToMakeSorted.minDeletionSize(A));
    }


    public static int minDeletionSize2(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
   }

}