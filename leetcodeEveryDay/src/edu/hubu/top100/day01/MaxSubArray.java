package edu.hubu.top100.day01;

import java.util.Arrays;

/**
 * @author: sugar
 * @date: 2022/3/7
 * @description: 最大连续子数组的和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int maxSum = nums[0];
        for (int x : nums) {
            preSum = Math.max(preSum + x, x);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray array = new MaxSubArray();
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // System.out.println(array.maxSubArray(nums));
        //
        // int[] nums1 = {5,4,-1,7,8};
        // System.out.println(array.maxSubArray(nums1));

        int[] nums2 = {-1, 0, -2};
        System.out.println(array.maxSubArray(nums2));
    }


}
