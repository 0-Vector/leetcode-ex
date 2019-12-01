package com.penny.leetcode.zhp.algorithm.leetcode;

/**爬楼梯
 * @author zhangpeng110
 * @create 2019/12/1 0001
 * @desc
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

 *
 */
public class L70ClimbingStairs {
    /**
     *题解:
     * 最优子结构，边界，状态转换方程
     *
     * 最优子结构：最后一个台阶是到达第n个台阶，这是有两种情况，站在第n-2个台阶，直接上2个台阶，站在第n
     * 个台阶直接上1个台阶,所以第n个台阶的总的走法是 n-1个台阶和n-2个台阶走法的和
     *  状态装换方程  f(n)=f(n-1)+f(n-2)  n>0;
     *  边界：f(1)=1
     *       f(2)=2
     *
     *
     *
     *
     *
     * @param n  台阶数
     * @return
     */
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int temp[]=new int[n+1];
        temp[0]=0;
        temp[1]=1;
        temp[2]=2;
        for(int i=3;i<=n;i++){
           temp[i]=temp[i-1]+temp[i-2];
        }
     return temp[n];
    }

    public static void main(String[] args) {
        System.out.println(L70ClimbingStairs.climbStairs(3));
    }

}