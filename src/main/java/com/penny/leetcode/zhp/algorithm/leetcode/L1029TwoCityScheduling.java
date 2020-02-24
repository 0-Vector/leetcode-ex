package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author zhangpeng110
 * @create 2020/2/7 0007
 * @desc
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。

返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。

 

示例：

输入：[[10,20],[30,200],[400,50],[30,20]]
输出：110
解释：
第一个人去 A 市，费用为 10。
第二个人去 A 市，费用为 30。
第三个人去 B 市，费用为 50。
第四个人去 B 市，费用为 20。

最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。

 */
public class L1029TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        int[] cost = new int[costs.length];
        int sumB = 0;
        int sumAB = 0;
        for(int i=0 ; i < costs.length;i++){
          int A = costs[i][0];
          int B = costs[i][1];
           sumB = sumB+B;
           cost[i] = B-A;
        }
        Arrays.sort(cost);
        for(int i =costs.length-1;i>costs.length/2-1;i--){
            sumAB = sumAB + cost[i];
        }
        return sumB-sumAB;
    }

    public static void main(String[] args) {
      int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(L1029TwoCityScheduling.twoCitySchedCost(costs));
    }

}