package com.penny.leetcode.problems.bytedance;

import java.util.LinkedList;
import java.util.List;

/**
 * 我手中有一堆扑克牌， 但是观众不知道它的顺序。
 * 第一步， 我从牌顶拿出一张牌， 放到桌子上。
 * 第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
 * 第三步， 重复前两步的操作， 直到我手中所有的牌都放到了桌子上。
 * 最后， 观众可以看到桌子上牌的顺序是：13\12\11\10\9\8\7\6\5\4\3\2\1
 * 请问， 我刚开始拿在手里的牌的顺序是什么？请用一个完整的函数来实现这一过程
 *
 * @author 0-Vector
 * @date 2019/11/18
 */
public class Poker {

    public List<Integer> getOriginSeries(int[] deskSeries) {
        LinkedList<Integer> inHandSeries = new LinkedList<>();
        for (int deskSer : deskSeries) {
            if (!inHandSeries.isEmpty()) {
                inHandSeries.addFirst(inHandSeries.pollLast());
            }
            inHandSeries.addFirst(deskSer);
        }
        return inHandSeries;
    }

    public int[] getOriginSeriesV1(int[] deskSeries) {
        int[] originSeries = new int[deskSeries.length];
        originSeries[0] = deskSeries[deskSeries.length - 1];
        int pos = 0;
        for (int i = deskSeries.length - 2; i >= 0; i--) {
            pos = findNextPos(originSeries, pos);
            originSeries[pos] = deskSeries[i];
        }
        return originSeries;
    }

    private int findNextPos(int[] originSeries, int currPos) {
        boolean isSkipOnePos = false;
        while (true) {
            if (++currPos >= originSeries.length) {
                currPos -= originSeries.length;
            }
            if (originSeries[currPos] == 0) {
                if (isSkipOnePos) {
                    return currPos;
                } else {
                    isSkipOnePos = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] deskSeries = {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        List<Integer> originSeries = new Poker().getOriginSeries(deskSeries);
        for (int originSer : originSeries) {
            System.out.print(originSer + " ");
        }
    }

}
