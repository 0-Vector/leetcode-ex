package com.penny.leetcode.tcq.problems.medium;

import com.penny.leetcode.tcq.problems.easy.L198HouseRobber;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 0-Vector
 * @date 2019/11/26 18:34
 */
public class L213HouseRobberII {

    /**
     * 动态规划（自底向上方法）
     * 借助L198实现
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
//        return Integer.max(robMax(Arrays.copyOfRange(nums, 0, nums.length - 1)), robMax(Arrays.copyOfRange(nums, 1, nums.length)));
        L198HouseRobber houseRobber = new L198HouseRobber();
        return Integer.max(houseRobber.rob(Arrays.copyOfRange(nums, 0, nums.length - 1)), houseRobber.rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }


//    private int robMax(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[][] amount = new int[nums.length][2];
//        amount[1][0] = nums[0];
//        amount[1][1] = nums[1];
//        for (int i = 2; i < nums.length; i++) {
//            amount[i][0] = Integer.max(amount[i-1][0], amount[i-1][1]);
//            amount[i][1] = nums[i] + amount[i - 1][0];
//        }
//        return Integer.max(amount[nums.length-1][0], amount[nums.length-1][1]);
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,4};
        System.out.println(new L213HouseRobberII().rob(nums));
    }
}
