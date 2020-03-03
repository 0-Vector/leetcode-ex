package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * Creator:Administrator
 * Time:2020-03-03 16:55
 * Project: leetcode-ex
 * Description:
 *给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

  

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 提示：
 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小
 *
 *
 */
public class L239SlidingWindowMaximum {
    /**思路：
     * 每次比较出窗口和进窗口的数，从而判断出需要计算还是直接可以得到
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //

        if(nums.length <=0 || k<=0 ){

            return new int[0];
        }

        int windowNum = nums.length-k+1;
        int[] ans = new int[windowNum];

        for(int i = 0; i <windowNum;i++){
            if(i == 0){
              ans[i] = arrayMax(nums,i,i+k-1);
              continue;
             }
             if(ans[i-1] != nums[i-1]){
                 if(ans[i-1] >= nums[i+k-1]){
                     ans[i] = ans[i-1];
                 }else{
                     ans[i] = nums[i+k-1];
                 }
             }else{
                 ans[i] = arrayMax(nums,i,i+k-1);
             }
        }
        return ans;
    }

    private static int arrayMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start;i<=end;i++){
           if(nums[i] > max){
               max = nums[i];
           }
        }
        return max;
    }

    public static void main(String[] args) {
      int[] nums = {};
        printArray(L239SlidingWindowMaximum.maxSlidingWindow(nums,0));
    }

    public static  void printArray(int [] array){
        for(int ele : array){
            System.out.print(ele+"  ");
        }
    }

}
