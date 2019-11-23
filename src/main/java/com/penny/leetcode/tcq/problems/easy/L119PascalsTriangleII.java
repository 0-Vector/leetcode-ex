package com.penny.leetcode.tcq.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/10/23 9:20
 */
public class L119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        if (rowIndex < 0 || rowIndex > 33) {
            return new ArrayList<Integer>(0);
        }

        List<Integer> integers = new ArrayList<>(rowIndex);

        if (rowIndex == 0) {
            integers.add(1);
            return integers;
        }

        List<Integer> preRow = getRow(rowIndex - 1);
        for (int colIndex = 0; colIndex < rowIndex + 1; colIndex++) {
            if (colIndex == 0 || colIndex == rowIndex) {
                integers.add(1);
            } else {
                integers.add(preRow.get(colIndex - 1) + preRow.get(colIndex));
            }
        }
        return integers;
    }

}
