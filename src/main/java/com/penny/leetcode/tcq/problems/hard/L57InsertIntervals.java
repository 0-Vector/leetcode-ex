package com.penny.leetcode.tcq.problems.hard;

import java.util.Stack;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/22 19:00
 */
public class L57InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length != 2) {
            return intervals;
        }
        int leftCount = 0;
        int i = 0;
        while (i < intervals.length) {
            int[] curr = intervals[i];
            if (newInterval[0] > curr[1]) {
                leftCount++;
                i++;
            } else if (newInterval[1] < curr[0]){
                break;
            } else {
                if (newInterval[0] > curr[0]) {
                    newInterval[0] = curr[0];
                }
                if (newInterval[1] < curr[1]) {
                    newInterval[1] = curr[1];
                }
                i++;
            }
        }
        int[][] ret = new int[leftCount + 1 + intervals.length - i][2];
        if (leftCount > 0) {
            System.arraycopy(intervals, 0, ret, 0, leftCount);
        }
        ret[leftCount] = newInterval;
        if (i < intervals.length) {
            System.arraycopy(intervals, i, ret, leftCount+1, intervals.length - i);
        }
        return ret;
    }

    public int[][] insertV1(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length != 2) {
            return intervals;
        }
        int length = intervals.length;
        if (newInterval[0] > intervals[length-1][1]) {
            int[][] ret = new int[length+1][2];
            System.arraycopy(intervals, 0, ret, 0, length);
            ret[length] = newInterval;
            return ret;
        } else {
            Stack<int[]> stack = new Stack<>();
            stack.push(newInterval);
            int i = 0;
            for (; i < length; i++) {
                if (intervals[i][0] > stack.peek()[1]) {
                    break;
                } else if (intervals[i][1] < stack.peek()[0]) {
                    int[] top = stack.pop();
                    stack.push(intervals[i]);
                    stack.push(top);
                } else {
                    int[] top = stack.pop();
                    stack.push(new int[]{Math.min(top[0], intervals[i][0]), Math.max(top[1], intervals[i][1])});
                }
            }
            int size = stack.size();
            int[][] ret = new int[size + length - i][2];
            for (int j = size - 1; j >= 0; j--) {
                ret[j] = stack.pop();
            }
            System.arraycopy(intervals, i, ret, size, length - i);
            return ret;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        L57InsertIntervals l57InsertIntervals = new L57InsertIntervals();
        l57InsertIntervals.insert(intervals, newIntervals);
    }
}
