package edu.hubu.top100.day04;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-03
 * @Description: 抢劫房屋
 **/
public class Rob {

    /**
     * 使用动态规划
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int first = nums[0];
        if (len == 1) return first;
        int[] dp = new int[len];
        dp[0] = first;
        dp[1] = Math.max(first, nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    /**
     * 使用动态规划 + 滚动数组
     *
     * @param nums
     */
    public int rob1(int[] nums) {
        int len = nums.length;
        int first = nums[0];
        if (len == 1) return first;
        int second = Math.max(first, nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob1(new int[]{2, 1, 1, 2}));
    }
}
