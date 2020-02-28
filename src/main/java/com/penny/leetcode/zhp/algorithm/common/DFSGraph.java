package com.penny.leetcode.zhp.algorithm.common;

import java.util.Stack;

/**
 * @author zhangpeng110
 * @create 2020/2/26 0026
 * @desc
 */
public class DFSGraph {

    private static Stack<Integer> stack = new Stack<>();
    private static int [] visited;
    public static void dfs(int [][] graph){
        visited = new int[graph.length];
        int node = 0;
        visited[node] =1;
        stack.push(node);
        printNode(node);
        while (!stack.isEmpty()){
         int anode  = findAdjacent(graph,stack.peek());
          if(anode == -1){
              stack.pop();
          }else{
              visited[anode] =1;
              stack.push(anode);
              printNode(anode);
          }
        }
    }

    private static int findAdjacent(int[][] graph, Integer node) {
        for(int i=0;i < graph.length;i++){
            if(i == node) continue;
            if(graph[node][i] == 1 && visited[i]==0){
                return  i;
            }
        }
        return -1;
    }

    private  static  void printNode(int node){
        System.out.print(node);
        System.out.print(",");
    }


    public static void main(String[] args) {
        int[][] graph =
                {{1,1,0,1},
                 {1,1,1,0},
                 {0,1,1,1},
                 {1,0,1,1
                 }};
        DFSGraph.dfs(graph);


    }


}