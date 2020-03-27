package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpeng110
 * @create 2020/3/27 0027
 * @desc
 * 给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L914XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length <= 0) return false;
        int[] count = new int[10001];
        for(int a:deck){
            count[a]++;
        }
        List<Integer> values = new ArrayList();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (count[i] < min) {
                    min = count[i];
                }
                values.add(count[i]);
            }
        if(min < 2){
            return false;
        }
          int x = values.get(0);
          for(Integer num:values){
             x =  gcd(x,num);
             if(x < 2 ) return false;
          }
      return true;
    }

    public static int gcd(int m,int n){ //使用递归算法实现

        if(n==0){
            return m;
        }else{
            return gcd(n,m%n);
        }
    }
}