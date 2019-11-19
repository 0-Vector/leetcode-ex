package com.penny.leetcode.problems.easy;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 *
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 *
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * 提示：
 * 1. 3 <= A.length <= 10000
 * 2. 1 <= A[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/19 13:04
 */
public class L976LargestPerimeterTriangle {
    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        int i = a.length;
        int z = a[--i], y = a[--i], x = a[--i];
        while (z >= x + y) {
            if (i > 0) {
                z = y;
                y = x;
                x = a[--i];
            } else {
                return 0;
            }

        }
        return x + y + z;
    }

    public static void main(String[] args) {
        int[] triEdge = {80, 70, 50, 30, 20, 10, 6, 4, 2, 1, 1, 1};
        L976LargestPerimeterTriangle triangle = new L976LargestPerimeterTriangle();
        System.out.println(triangle.largestPerimeter(triEdge));
    }
}
