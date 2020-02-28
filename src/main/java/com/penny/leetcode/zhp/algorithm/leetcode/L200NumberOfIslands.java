package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Stack;

/**
 * @author zhangpeng110
 * @create 2020/2/25 0025
 * @desc
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
示例 1:
输入:
11110
11010
11000
00000
输出: 1
示例 2:
输入:
11000
11000
00100
00011
输出: 3
 *
 */
public class L200NumberOfIslands {
    /**
     * 利用深度优先遍历，将遍历过的陆地全部改为水
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
         for(int i = 0;i < grid.length;i++){
              for(int j = 0;j < grid[i].length ; j++){
                  if(grid[i][j] == '1'){
                      dfs(grid, i, j);
                      num ++;
                  }
              }
         }

         return num;
    }
    public static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}