package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/16 0016
 * @desc
 *
在一个 m*n 的棋盘的每一格都放有一个礼物，
每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，
请计算你最多能拿到多少价值的礼物？
示例 1:
输入:
[1,3,1],
[1,5,1],
[4,2,1]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 
提示：
0 < grid.length <= 200
0 < grid[0].length <= 200
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class M47LiWuDeZuiDaJieZhiLcof {


    /**
     # 状态:每一步
     # dp[i][j]:当前状态的最大价值
     # 状态转移方程:dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     *
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;

        int rows = grid.length; //行
        int cols = grid[0].length; //列

        int[][] maxValue = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int left = 0;
                int up = 0;
                if(i>0)
                    up = maxValue[i-1][j];
                if(j>0)
                    left = maxValue[i][j-1];
                maxValue[i][j] = Math.max(up, left) + grid[i][j];
            }
        }
        return maxValue[rows-1][cols-1];
    }
}