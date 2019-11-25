package com.penny.leetcode.tcq.problems.hard;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * /|
 *  |       E
 *  |   EoooEEoE
 *  | EoEEoEEEEEE
 *  |------------------>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lambda
 * @date 2019/11/19 21:23
 */
public class L42TrappingRainWater {

    public int trap(int[] height) {

        return 0;
    }

    /*
     * 运行超时
     */
    public int trapV1(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int trapCount = 0;
        int maxHeight = Arrays.stream(height).max().getAsInt();
        while (true) {
            int i = 0;
            for (; i < height.length; i++) {
                if (height[i] > 0) {
                    height[i]--;
                    break;
                }
            }
            int j = height.length - 1;
            for (; j > i; j--) {
                if (height[j] > 0) {
                    height[j]--;
                    break;
                }
            }
            if (j - i <= 1) {
                break;
            }
            for (int k = i + 1; k < j; k++) {
                if (height[k] == 0) {
                    trapCount++;
                } else {
                    height[k]--;
                }
            }
        }
        return trapCount;
    }

    public static void main(String[] args) {
        int[] height = {10527,740,9013,1300,29680,4898,13993,15213,18182};
        new L42TrappingRainWater().trap(height);
    }
}
