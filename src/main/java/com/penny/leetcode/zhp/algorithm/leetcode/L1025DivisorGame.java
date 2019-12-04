package com.penny.leetcode.zhp.algorithm.leetcode;

/** 除数博弈
 * @author zhangpeng110
 * @create 2019/12/3 0003
 * @desc

 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。
只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
示例 1：
输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：
输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
提示：
1 <= N <= 1000
 *
 */
public class L1025DivisorGame {
    /**
     * 题解：
     *
     *-
     *
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {

        if(N==0){
            return false;
        }
        if(N==1){
            return true;
        }
        boolean temp=false;
        while(true){
            //爱丽丝选择
            boolean si=false;
            boolean bo=false;
            for(int x=1;x<N;x++){
                if(N % x == 0){
                     N=N-x;
                    si=true;
                    break;
                }
            }
           //鲍勃
            for(int x=1;x<N;x++){
                if(N % x == 0){
                    N=N-x;
                    bo=true;
                    break;
                }
            }
            if(!si){
                temp=false;
                break;
            }
            if(!bo){
                temp=true;
                break;
            }
        }
       return temp;
    }

    public static void main(String[] args) {
        System.out.println(L1025DivisorGame.divisorGame(10));
    }
}