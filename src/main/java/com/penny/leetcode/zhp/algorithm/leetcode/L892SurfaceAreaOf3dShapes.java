package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/26 0026
 * @desc
 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
请你返回最终形体的表面积。
示例 1：
输入：[[2]]
输出：10
示例 2：
输入：[[1,2],[3,4]]
输出：34
示例 3：
输入：[[1,0],[0,2]]
输出：16
示例 4：
输入：[[1,1,1],[1,0,1],[1,1,1]]
输出：32
示例 5：
输入：[[2,2,2],[2,1,2],[2,2,2]]
输出：46
 *
 */
public class L892SurfaceAreaOf3dShapes {

    /**
     * 分层迭代处理
     * @param grid
     * @return
     */
    public static int surfaceArea(int[][] grid) {
        if(grid == null || grid.length <= 0){
            return 0;
        }
        int inc = 1;
        int sum = 0;
        lable2:
        while(true){
            boolean temp  = false;
            for(int i = 0;i<grid.length;i++){
               for(int j = 0;j<grid.length;j++){
                   if(grid[i][j] >= inc){
                       temp = true;
                       sum += calculateSurface(grid,i,j,inc);
                   }
               }
            }
            if(!temp) break lable2;
            inc ++;
        }
      return  sum;
    }

    private static   int calculateSurface(int[][] grid, int x, int y,int inc) {
        int sum = 5;
        int xlength = grid.length;
        int ylength = grid[0].length;
            if(x-1 >=0){
               sum = grid[x-1][y] >= inc ?sum-1:sum;
            }
            if(y-1 >= 0){
                sum = grid[x][y-1] >= inc ?sum-1:sum;
            }
            if(x+1 < xlength){
                sum = grid[x+1][y] >= inc ?sum-1:sum;
            }
            if(y+1 < ylength){
                sum = grid[x][y+1] >= inc ?sum-1:sum;
            }
           if(inc == 1){
              sum = sum +1;
            }
            if(inc < grid[x][y]){
                sum = sum - 1;
            }
        return sum;
    }

    public static void main(String[] args) {
        int[][] ans = {{1,0},{0,2}};
        System.out.println(L892SurfaceAreaOf3dShapes.surfaceArea(ans));
    }

}