package com.penny.leetcode.tcq.problems.easy;

import java.time.Instant;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/11/26 18:31
 */
public class L198HouseRobber {

    /*
     * 动态规划（自底向上方法）
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[][] amount = new int[nums.length][2];
        amount[1][0] = nums[0];
        amount[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            amount[i][0] = Integer.max(amount[i-1][0], amount[i-1][1]);
            amount[i][1] = nums[i] + amount[i - 1][0];
        }
        return Integer.max(amount[nums.length-1][0], amount[nums.length-1][1]);
    }

    /*
     * 动态规划方法（带备忘的自顶向下）
     */
    public int robV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[][] amount = new int[nums.length][2];
        for (int i = 0; i < amount.length; i++) {
            amount[i][0] = -1;
            amount[i][1] = -1;
        }
        return Integer.max(nums[nums.length-1] + robWithMemo(true, nums.length - 2, nums, amount), robWithMemo(false, nums.length - 2, nums, amount));
    }

    private int robWithMemo(boolean flag, int i, int[] nums, int[][] amount) {
        if (i == 0) {
            return flag ? 0 : nums[0];
        }
        if (amount[i][0] == -1) {
            amount[i][0] = robWithMemo(false, i - 1, nums, amount);
        }
        if (amount[i][1] == -1){
            amount[i][1] = nums[i] + robWithMemo(true, i - 1, nums, amount);
        }
        return flag ? amount[i][0] : Integer.max(amount[i][0], amount[i][1]);
    }


    /*
     * 朴素递归（耗时）
     */
    public int robV1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Integer.max(nums[0] + robMax(true, 1, nums), robMax(false, 1, nums));
    }

    private int robMax(boolean flag, int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (flag) {
            return robMax(false, i + 1, nums);
        } else {
            return Integer.max(nums[i] + robMax(true, i + 1, nums), robMax(false, i + 1, nums));
        }
    }

    public static void main(String[] args) {
        long t1 = Instant.now().toEpochMilli();
        int nums[] = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
//        int nums[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int nums[] = {8, 1, 2, 9};
        int rob = new L198HouseRobber().rob(nums);
        long t2 = Instant.now().toEpochMilli();
        System.out.println(rob);
        System.out.println(t2 - t1);
    }
}
