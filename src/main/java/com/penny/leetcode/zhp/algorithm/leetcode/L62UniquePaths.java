package com.penny.leetcode.zhp.algorithm.leetcode;

/**不同路径
 * @author zhangpeng110
 * @create 2019/12/10 0010
 * @desc
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:
输入: m = 7, n = 3
输出: 28
 题解：
 最优子结构：到达最后一个位置,可以通过两种方式，前一个位置向下或者向右
 状态转换方程：f(m,n)=f(m-1,n)+f(m,n-1)
 边界：当站在第一个位置时，向下或者向右发,f(0,1)=1,f(1,0)=1




 */
public class L62UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m<=0||n<=0){
            return 0;
        }
        int [][]dd=new int[n][m];
        for(int i=0;i<n;i++){
            dd[i][0]=1;
        }
        for(int j=0;j<m;j++){
            dd[0][j]=1;
        }
        for(int a=1;a<m;a++){
            for(int b=1;b<n;b++){
                dd[b][a]=dd[b-1][a]+dd[b][a-1];
            }
        }
     return dd[n-1][m-1];
    }


    public static int uniquePaths2(int m, int n) {
        if((n==1||m==1)){
            return 1;
        }
        return uniquePaths2(m-1,n)+uniquePaths2(m,n-1);
    }




    public static void main(String[] args) {
        int m=3,n=2;
        System.out.println(L62UniquePaths.uniquePaths2(m,n));
    }

}