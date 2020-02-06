package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author zhangpeng110
 * @create 2020/2/4 0004
 * @desc
 *有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 */
public class L1046LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        if(stones==null || stones.length==0){
            return 0;
        }
        if(stones.length==1){
            return stones[0];
        }
        Arrays.sort(stones);
        int len = stones.length-1;
        int val = 0;
        while (len >=1){
            val = Math.abs(stones[len]-stones[len-1]);
          //if ( val!=0){
              //将 新石头插入合适的位置
              insertStone(stones,val,len-2);
              len-=1;
          /* }else{
              len-=2;
          }*/
        }
      return val;
    }

    private static   void insertStone(int[] stones, int val,int pos) {
        while (pos >= 0){
            if(stones[pos] > val){
                stones[pos+1] = stones[pos];
                pos--;
            }else{

                break;
            }

        }
        stones[pos+1] = val;
    }

    public static void main(String[] args) {
        int[] array = {2,7,4,1,8,1};
        System.out.println(L1046LastStoneWeight.lastStoneWeight(array));
    }

}