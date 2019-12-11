package com.penny.leetcode.tcq.basic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 最佳：n-1
 * 最差：n(n-1)/2
 * 时间复杂度：O(n^2)
 *
 * @author 0-Vector
 * @date 2019/12/04 19:22
 */
public class BubbleSort {
    /**
     * 如果某一轮没有发生交换，则结束排序
     * @param nums 待排序数组
     */
    public static void bubbleSort(int[] nums) {
        boolean needNext = true;
        for (int i = 0; i < nums.length-1 && needNext; i++) {
            needNext = false;
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    needNext = true;
                }
            }
        }
    }

    /**
     * 第i次排序，不需要考虑后i-1个元素
     * @param nums 待排序数组
     */
    public static void bubbleSortV1(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,9,8,4,5,7};
        BubbleSort.bubbleSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
