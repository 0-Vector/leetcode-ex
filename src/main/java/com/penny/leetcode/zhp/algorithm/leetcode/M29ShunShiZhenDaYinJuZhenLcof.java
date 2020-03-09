package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/7 0007
 * @desc
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。


示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class M29ShunShiZhenDaYinJuZhenLcof {

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length <= 0){
            return  new int[0];
        }
        int [] res = new int[matrix.length * matrix[0].length];
        int [][] temp = new int[matrix.length][matrix[0].length];
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int  down = matrix.length-1;
        int sum = -0;
        while (up <= down && left <= right){
            for(int a = 0;a < matrix[0].length;a++){
                if(temp[up][a] == 0){
                    res[sum++] = matrix[up][a];
                    temp[up][a] = 1;
                }
            }
            for(int a = 0;a < matrix.length;a++){
                if(temp[a][right] == 0){
                    res[sum++] = matrix[a][right];
                    temp[a][right] = 1;
                }
            }

            for(int a = matrix[0].length-1;a >= 0;a--){
                if(temp[down][a] == 0){
                    res[sum++] = matrix[down][a];
                    temp[down][a] = 1;
                }
            }

            for(int a = matrix.length-1;a >= 0;a--){
                if(temp[a][left] == 0){
                    res[sum++] = matrix[a][left];
                    temp[a][left] = 1;
                }
            }
            up++;
            left++;
            down--;
            right--;
        }
       return res;
    }

    public static void main(String[] args) {
        int[][] temp = {{1}};
        int[] ans = M29ShunShiZhenDaYinJuZhenLcof.spiralOrder(temp);
        for(int a :ans){
            System.out.print(a+"  ");
        }
    }


}