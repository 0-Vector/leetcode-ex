package com.penny.leetcode.problems.easy;

import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * 提示：
 * 1. 2 <= A.length <= 20000
 * 2. A.length % 2 == 0
 * 3. 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 0-Vector
 * @date 2019/11/18
 */
public class L922SortedArrayByParityII {
    public int[] sortArrayByParityII(int[] a) {
        int[] sortedArray = new int[a.length];
        int oddCount = 0, evenCount = 0;
        for (int i : a) {
            if (i % 2 == 1) {
                sortedArray[(oddCount << 1) + 1] = i;
                oddCount++;
            } else {
                sortedArray[evenCount << 1] = i;
                evenCount++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        L922SortedArrayByParityII parityII = new L922SortedArrayByParityII();
        int[] sortArray = parityII.sortArrayByParityII(a);
        for (int i : sortArray) {
            System.out.println(i);
        }

    }
}
