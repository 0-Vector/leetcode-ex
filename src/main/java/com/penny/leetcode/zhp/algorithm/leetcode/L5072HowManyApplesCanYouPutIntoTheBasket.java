package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author zhangpeng110
 * @create 2020/2/2 0002
 * @desc
 *
 * 楼下水果店正在促销，你打算买些苹果，arr[i] 表示第 i 个苹果的单位重量。
你有一个购物袋，最多可以装 5000 单位重量的东西，算一算，最多可以往购物袋里装入多少苹果。
示例 1：

输入：arr = [100,200,150,1000]
输出：4
解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
示例 2：

输入：arr = [900,950,800,1000,700,800]
输出：5
解释：6 个苹果的总重量超过了 5000，所以我们只能从中任选 5 个。
提示：

1 <= arr.length <= 10^3
1 <= arr[i] <= 10^3
 *
 *
 */
public class L5072HowManyApplesCanYouPutIntoTheBasket {
    public static  int  maxNumberOfApples(int [] apple){
        Arrays.sort(apple);
        int sum = 0;
        int num = 0;
        for(int i = 0;i<apple.length;i++){
           sum = sum+apple[i];
            if(sum >= 5000){
                break;
            }
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        //int[] apple = {900,950,800,1000,700,800};
        int[] apple = {100,200,150,1000};
        System.out.println(L5072HowManyApplesCanYouPutIntoTheBasket.maxNumberOfApples(apple));
    }



}