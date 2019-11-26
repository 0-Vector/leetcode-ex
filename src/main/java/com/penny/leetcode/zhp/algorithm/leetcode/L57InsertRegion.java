package com.penny.leetcode.zhp.algorithm.leetcode;

import com.penny.leetcode.zhp.algorithm.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 插入区间
 *
 * @author zhangpeng110
 * @create 2019/11/23 0023
 * @desc 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class L57InsertRegion {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = {};
        List<int[]> list=new ArrayList<>();
        if (intervals.length <= 0 && newInterval.length <= 0) {
            return result;
        }
        if (intervals.length <= 0 && newInterval.length > 0) {
            result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        if (intervals.length > 0 && newInterval.length <= 0) {
            return intervals;
        }
        int[] mm;
        int i = 0;
        boolean isFind = false;
        while (i < intervals.length) {
            mm = intervals[i];
            if ((mm[0] > newInterval[0] && !isFind)) {
                isFind = true;



            }else{
                list.add(mm);
            }
        }
     /*   result = new int[stackLen][2];
        //int i=0;
        while (!stack.isEmpty()) {
            result[--stackLen] = stack.pop();
        }*/
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        //int [][] intervals={{1,3},{6,9}};
        // [] newInterval={2,5};
        L57InsertRegion l57InsertRegion = new L57InsertRegion();
        PrintUtils.printTwoDimension(l57InsertRegion.insert(intervals, newInterval));
    }



    public int[][] insertOne(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<int[]>();
        int[][] result = {};
        if (intervals.length <= 0 && newInterval.length <= 0) {
            return result;
        }
        if (intervals.length <= 0 && newInterval.length > 0) {
            result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        if (intervals.length > 0 && newInterval.length <= 0) {
            return intervals;
        }
        int[] temp;
        int[] data;
        int[] mm;
        int i = 0;
        boolean isFind = false;
        while (i < intervals.length) {
            mm = intervals[i];
            if ((mm[0] > newInterval[0] && !isFind)) {
                isFind = true;
                mm = newInterval;
                i--;
            }
            if (stack.isEmpty()) {
                stack.push(mm);
            } else {
                temp = stack.pop();
                if (mm[1] <= temp[1]) {
                    //区间包住了
                    stack.push(temp);
                } else if (mm[0] <= temp[1]) {
                    data = new int[2];
                    data[0] = temp[0];
                    data[1] = mm[1];
                    stack.push(data);
                } else {
                    stack.push(temp);
                    stack.push(mm);
                }
            }
            if(i==intervals.length-1 && !isFind){
                isFind=true;
                intervals[i]=newInterval;
            }else{
                i++;
            }
        }
        //处理插入到最后的情况
        int stackLen = stack.size();
        result = new int[stackLen][2];
        //int i=0;
        while (!stack.isEmpty()) {
            result[--stackLen] = stack.pop();
        }
        return result;
    }
}