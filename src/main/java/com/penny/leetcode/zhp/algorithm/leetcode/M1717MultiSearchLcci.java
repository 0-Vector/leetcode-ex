package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangpeng110
 * @create 2020/3/9 0009
 * @desc 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 */
public class M1717MultiSearchLcci {

    public static int[][] multiSearch(String big, String[] smalls) {
        if(smalls.length <= 0  ){
            return new int[0][0];
        }
        if(big.length() <= 0){
            return new int[smalls.length][0];
        }
        if((smalls.length ==1 && smalls[0].isEmpty())){
            return new int[smalls.length][0];
        }
        int[][] ans = new int[smalls.length][];
        for (int a = 0; a < smalls.length; a++) {
            if(smalls[a].isEmpty()){
                break;
            }
            int j = 0;
            List<Integer> res = new ArrayList<>();
            int[] tep;
            while (j <  big.length()){
                    if (big.charAt(j) == smalls[a].charAt(0)) {
                    int t = j;
                    int b = 0;
                    boolean temp = true;
                    while (b < smalls[a].length() && t < big.length()) {
                        if (smalls[a].charAt(b) != big.charAt(t)) {
                            temp = false;
                            break;
                        }
                        b++;
                        t++;
                    }
                    if(temp && t-j == smalls[a].length()){
                        res.add(j);
                        j = t+1;
                    }else{
                        j ++;
                    }
                  }else{
                        j++;
                    }
            }
            if(res.size()>0){
                tep = new int[res.size()];
                for(int i = 0; i <res.size(); i++ ){
                    tep[i] = res.get(i);
                }
                ans[a] =  tep;


            }else{
                ans[a] = new int[0];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
         String    big = "mississippi";
         String[]  smalls = {"is","ppi","hi","sis","i","ssippi"};
        M1717MultiSearchLcci.multiSearch(big,smalls);



    }

}