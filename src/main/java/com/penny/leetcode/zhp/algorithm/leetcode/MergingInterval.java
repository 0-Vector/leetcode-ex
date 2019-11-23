package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Creator:张鹏
 * Time:2019-11-22 13:02
 * Project: algorithm
 * Description:
 给出一个区间的集合，请合并所有重叠的区间。
 示例 1:
 输入: [[1,3],[2,3],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:
 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 */
public class MergingInterval {


    public static int[][] merge(int[][] intervals) {
        Stack<int[]> stack=new Stack<int[]>();
        int[][] result={};
        if(intervals.length<=0){
            return result;
        }
        int [] temp;
        int [] data;

        Arrays.sort(intervals,(x,y) -> (x[0]-y[0]));
        for(int i=0;i<intervals.length;i++){
                //判断是否是可以合并的区间

             if(stack.isEmpty()){
                 stack.push(intervals[i]);
                 continue;
             }
             temp=stack.pop();
             if(intervals[i][1]<=temp[1]){
                 //区间包住了
                 stack.push(temp);
                 continue;
             }
             if(intervals[i][0]<=temp[1]){
                data=new int[2];
                data[0]= temp[0];
                data[1] =intervals[i][1];
                stack.push(data);
                 continue;
             }
            stack.push(temp);
            stack.push(intervals[i]);

        }
        int stackLen=stack.size();
        result=new int[stackLen][2];
        //int i=0;
        while(!stack.isEmpty()){
            result[--stackLen]=stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        //int[][] data={{1,4},{2,3},{8,10},{15,18}};
        int[][] data={{1,4},{4,5}};
        print(merge(data));


    }



    public  static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + "  |\t");

            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t"); // "\t"是制表符
            }
            System.out.println();
        }
    }


}
