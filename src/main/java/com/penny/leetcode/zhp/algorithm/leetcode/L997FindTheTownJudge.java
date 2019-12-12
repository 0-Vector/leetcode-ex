package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * 找到小镇的法官
 * @author zhangpeng110
 * @create 2019/12/11 0011
 * @desc
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

如果小镇的法官真的存在，那么：

小镇的法官不相信任何人。
每个人（除了小镇法官外）都信任小镇的法官。
只有一个人同时满足属性 1 和属性 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 

示例 1：

输入：N = 2, trust = [[1,2]]
输出：2
示例 2：

输入：N = 3, trust = [[1,3],[2,3]]
输出：3
示例 3：

输入：N = 3, trust = [[1,3],[2,3],[3,1]]
输出：-1
示例 4：

输入：N = 3, trust = [[1,2],[2,3]]
输出：-1
示例 5：

输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
输出：3
 

提示：

1 <= N <= 1000
trust.length <= 10000
trust[i] 是完全不同的
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N

 题解:
    抽象成图结构，求每个节点的出度和入度，初度等于入度等于n-1的即为法官



 *
 */
public class L997FindTheTownJudge {

    public static   int findJudge(int N, int[][] trust) {
        if(N<=0){
            return -1;
        }
        if(trust.length<=0 &&N==1){
            return 1;
        }
        if(trust.length<=0 &&N>1){
            return -1;
        }



         int[][] trustHome=new int[N+1][N+1];
        for(int i=0;i<trust.length;i++){
            trustHome[trust[i][1]][trust[i][0]]=1;
         }
        int out=-1;
        int in=-1;
        for(int t=1;t<N+1;t++){
            out=outSum(trustHome,t,N+1);
            in=inSum(trustHome,t,N+1);
            if(out==0 && in==N-1){
                return t;
            }

        }
        return -1;
    }

    private  static int inSum(int[][] trustHome, int t, int length) {
        int sum=0;
        for(int i=0;i<length;i++){
            sum=sum+trustHome[t][i];
        }
        return sum;
    }

    private  static int outSum(int[][] trustHome, int t,int length) {
        int sum=0;
        for(int i=0;i<length;i++){
            sum=sum+trustHome[i][t];
        }
        return sum;
    }

    public static void main(String[] args) {
        // [[1,3],[2,3],[3,1]]
        int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(L997FindTheTownJudge.findJudge(4,trust));



    }


}