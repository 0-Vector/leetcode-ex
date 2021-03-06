package com.penny.leetcode.tcq.problems.medium;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/11/21 19:06
 */
public class L75SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0, p = 0, q = nums.length - 1;
        while (i <= q) {
            if (nums[i] == 0) {
                while (p <= q && nums[p] == 0) {
                    p++;
                }
                if (p < i) {
                    swap(nums, i++, p++);
                } else if (p <= q) {
                    i = p;
                } else {
                    break;
                }
            } else if (nums[i] == 2){
                while (q >= i && nums[q] == 2) {
                    q--;
                }
                if (i < q) {
                    swap(nums, i, q--);
                } else {
                    break;
                }
            } else {
                i++;
            }
        }
    }

    public void sortColorsV1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0, redIndex = 0, blueIndex = nums.length - 1;
        while (i <= blueIndex) {
            if (nums[i] == 0) {
                swap(nums, i++, redIndex++);
            } else if (nums[i] == 2){
                swap(nums, i, blueIndex--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        new L75SortColors().sortColors(nums);
    }
}
