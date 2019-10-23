package com.penny.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/10/22 14:32
 */
public class L118PascalsTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            List<Integer> integers = new ArrayList<>(rowIndex + 1);
            for (int colIndex = 0; colIndex < (rowIndex + 1); colIndex++) {
                if (colIndex == 0 || colIndex == rowIndex) {
                    integers.add(1);
                } else {
                    integers.add(lists.get(rowIndex - 1).get(colIndex - 1) + lists.get(rowIndex - 1).get(colIndex));
                }
            }
            lists.add(integers);
        }
        return lists;
    }

}
