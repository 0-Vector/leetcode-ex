package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpeng110
 * @create 2020/2/4 0004
 * @desc
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。

你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 */
public class L1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> rel =  new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> list = map.get(groupSizes[i]);
            if(list == null || list.size() <= 0){
                list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i],list);
            }else{
                    list.add(i);

                    map.put(groupSizes[i],list);
            }
            if(list .size() == groupSizes[i]){
                rel.add(list);
                map.remove(groupSizes[i]);
            }
        }
      return rel;
    }

    public static void main(String[] args) {
     int []    groupSizes = {2,1,3,3,3,2};
     List<List<Integer>> list =  L1282GroupThePeopleGivenTheGroupSizeTheyBelongTo.groupThePeople(groupSizes);
     for(List<Integer> eme:list) {
         for(Integer rel:eme){
             System.out.print(rel+" ");
         }
         System.out.println();
     }
    }

}