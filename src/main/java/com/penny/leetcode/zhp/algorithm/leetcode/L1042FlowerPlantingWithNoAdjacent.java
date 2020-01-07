package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**不邻接植花
 * @author zhangpeng110
 * @create 2019/12/13 0013
 * @desc
 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
另外，没有花园有 3 条以上的路径可以进入或者离开。
你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
示例 1：
输入：N = 3, paths = [[1,2],[2,3],[3,1]]
输出：[1,2,3]
示例 2：
输入：N = 4, paths = [[1,2],[3,4]]
输出：[1,2,1,2]
示例 3：
输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
输出：[1,2,3,4]
提示：
1 <= N <= 10000
0 <= paths.size <= 20000
不存在花园有 4 条或者更多路径可以进入或离开。
保证存在答案。
 *       法一：
 *      图的算法
 *      用邻接表将图存起来，为每个节点着色。条件如下：
 *         当前节点的颜色是除去所有已经被着色的相邻的节点的值的最小值;
 */
public class L1042FlowerPlantingWithNoAdjacent {
    private static Map<Integer,List<Integer>> map=null;

    /**
     * 执行用时 :
     44 ms
     , 在所有 java 提交中击败了
     51.51%
     的用户
     * @param N
     * @param paths
     * @return
     */
    public static int[] gardenNoAdj(int N, int[][] paths) {
        if(N<=0){
            return new int[1];
        }
        if(N==1){
            int []res={1};
            return res;
        }
        if(paths.length<=0){
            return new int[1];
        }
        map=new HashMap<>();
        int []res=new int[N];
        List<Integer> temp0;
        List<Integer> temp1;
        for(int i=0;i<paths.length;i++){
            temp0=map.getOrDefault(paths[i][0],new ArrayList<>());
            temp1=map.getOrDefault(paths[i][1],new ArrayList<>());
            temp0.add(paths[i][1]);
            temp1.add(paths[i][0]);
            map.put(paths[i][0],temp0);
            map.put(paths[i][1],temp1);
        }
        for(int t=1;t<=N;t++){
            int []colorArray=new int[4];
            for(Integer data:map.get(t)){
               if(res[data-1]!=0){
                 colorArray[res[data-1]-1]=1;
               }
            }
            for(int f=1;f<=4;f++) {
               if(colorArray[f-1]==0){
                   res[t-1]=f;
                   break;
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int N=3;
        //int [][]paths = {{1,2},{2,3},{3,1}};
        int N=4;
        int [][]paths={{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        for(int data:L1042FlowerPlantingWithNoAdjacent.gardenNoAdj(N,paths))
        System.out.print(data+" ");
    }
}