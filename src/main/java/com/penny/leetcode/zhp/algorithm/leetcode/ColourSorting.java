package com.penny.leetcode.zhp.algorithm.leetcode;

/** 颜色分类
 * Creator:zhangpeng
 * Time:2019-11-21 13:42
 * Project: algorithm
 * Description:
 *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 注意:
 不能使用代码库中的排序函数来解决这道题。
 示例:
 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：
 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */
public class ColourSorting {

    public void sortColors(int[] nums){
        int red = 0, blue = nums.length - 1 ;
        while(nums[red]==0){red++;}
        while (nums[blue]==2){blue--;}
        int i=red;
        while(i<=blue){
            if (nums[i] == 0) {
                swapData(nums, i++, red++);
                continue;
            }
            if (nums[i] == 2){
                swapData(nums, i, blue--);
                continue;
            }
                i++;
       }

}


  private void swapData(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public static void main(String[] args) {
        int [] array={0,0,2,1,1,0,2,2,0,2,2};
        ColourSorting sorting=new ColourSorting();
        sorting.sortColors2(array);
        print(array);
    }


    public  static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public void sortColors2(int[] nums) {
        int red = 0, blue = nums.length - 1;

        while (nums[red] == 0 && red < nums.length) {
            red++;
        }
        while (nums[blue] == 2 && blue < nums.length) {
            blue--;
        }
        int i = red;
        while (i <= blue) {
            if (nums[i] == 0) {
                swapData(nums, i++, red++);
                continue;
            }
            if (nums[i] == 2) {
                swapData(nums, i, blue--);
                continue;
            }
            i++;
        }
    }



}
