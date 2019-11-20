package com.penny.leetcode.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lambda
 * @date 2019/11/20 21:53
 */
public class L56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
//        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > stack.peek()[1]) {
                stack.push(interval);
            } else if (interval[1] > stack.peek()[1]){
                stack.push(new int[]{stack.pop()[0], interval[1]});
            }
        }
        int[][] mergedIntervals = new int[stack.size()][2];
        for (int i = mergedIntervals.length - 1; i >= 0; i--) {
            mergedIntervals[i] = stack.pop();
        }
        return mergedIntervals;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{17,20},{1,3},{2,6},{8,10},{15,18}};
        L56MergeIntervals mergeIntervals = new L56MergeIntervals();
        mergeIntervals.merge(intervals);

    }
}
