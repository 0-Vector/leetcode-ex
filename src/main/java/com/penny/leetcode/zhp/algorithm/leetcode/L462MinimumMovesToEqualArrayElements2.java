package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/2/16 0016
 * @desc
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。

例如:
输入:
[1,2,3]
输出:
2
说明：
只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

 *
 *
 *
 */
public class L462MinimumMovesToEqualArrayElements2 {
    /**
     * 先求中位数
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int num = nums.length;
        int k = -1;
        if(num % 2 !=0){
            k = (num+1) /2;
        }else{
            k = num / 2;
        }

      int mid = findKth(nums,num,k);

      int sum = 0;

       for(int number : nums) {
           sum = sum + Math.abs(mid-number);
       }
       return sum;
    }
    public static int findKth (int[] array, int n, int k)
    {
        return findKth(0, n-1, array, k);
    }

    public static int findKth (int left, int right, int[] array, int k)
    {
        int m = partation(left, right, array);

        if ((m-left) > (k-1) && left<right)
        {
            return findKth(left, m-1, array, k);
        }
        else if ((m-left) < (k-1) && left<right)
        {
            return findKth(m+1, right, array, k-m+left-1);
        }
        else
        {
            return array[m];
        }
    }
    public static int partation (int left, int right, int[] array)
    {
        int key = array[left];
        while (left < right)
        {
            while (left<right && array[right]<=key)
            {
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left]>=key)
            {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
    public static void main(String[] args) {

    }
}