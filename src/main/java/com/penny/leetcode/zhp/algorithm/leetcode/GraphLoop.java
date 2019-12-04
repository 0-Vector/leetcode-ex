package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.*;

/**
 * Creator:zhangpenga
 * Time:2019-12-04 20:23
 * Project: leetcode-ex
 * Description:
 * 图的相关算法
 *
 */
public class GraphLoop {
    private Queue<String> queue = new LinkedList<String>();
    private Map<String, Boolean> status = new HashMap<String, Boolean>();
    private Map<String, List<String>> graph = new HashMap<String, List<String>>();
    public static void main(String[] args) {

    }
    public void BFSSearch(String startPoint) {
        //1.把起始点放入queue；
        queue.add(startPoint);
        status.put(startPoint, false);
        bfsLoop();
    }

    private void bfsLoop() {
        //  1) 从queue中取出队列头的点；更新状态为已经遍历。
        String currentQueueHeader = queue.poll(); //出队
        status.put(currentQueueHeader, true);
        System.out.println(currentQueueHeader);
        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
        List<String> neighborPoints = graph.get(currentQueueHeader);
        for (String poinit : neighborPoints) {
            if (!status.getOrDefault(poinit, false)) { //未被遍历
                if (queue.contains(poinit)) continue;
                queue.add(poinit);
                status.put(poinit, false);
            }
        }
        if (!queue.isEmpty()) {  //如果队列不为空继续遍历
            bfsLoop();
        }
    }

}
