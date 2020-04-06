package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/4/4 0004
 * @desc
 */
public class L912SortAnArray {
    final static Integer VALUE = 50000;
    public static
    int[] sortArray(int[] nums) {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            min =  Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int[] counter = new int[max - min + 1];
         for(Integer num:nums){
             counter[num - min]++;
         }
        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
     return nums;
    }


    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        System.out.println(L912SortAnArray.sortArray(nums));
    }

}