package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2019/12/22 0022
 * @desc
     这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 题解:
 转换为求解每个节点出度或者入度大于1的节点的个数
m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1

 */
public class L1267CountServersThatCommunicate {
    public static int countServers(int[][] grid) {
        if(grid.length<=0){
            return 0;
        }
        int m=grid.length;
        int sum=0;
        for(int i=0;i<m;i++){
           for(int j=0;j<grid[i].length;j++) {
               if (grid[i][j] == 0) {
                   continue;
               }
               //计算这个节点是否满足条件，同一条
               int aSum = 0;
               for (int a = 0; a < m; a++) {
                   aSum += grid[a][j];
               }
               int bSum = 0;
               for (int b = 0; b < grid[i].length; b++) {
                   bSum += grid[i][b];
               }
               if (aSum > 1 || bSum > 1) {
                   sum += 1;
               }
           }
        }
        return sum;
    }
    public static void main(String[] args) {
     //int[][]   grid = {{1,0},{1,1}};
      int [][] grid= {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(L1267CountServersThatCommunicate.countServers2(grid));
    }

    public static int countServers2(int[][] grid) {
        if(grid.length<=0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int [] count_m=new int[m];
        int [] count_n=new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++count_m[i];
                    ++count_n[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (count_m[i] > 1 || count_n[j] > 1)) {
                    ++ans;
                }
            }
        }
        return ans;
    }






}