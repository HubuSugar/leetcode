package edu.hubu.top100.day01;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: sugar
 * @date: 2022/3/5
 * @description: 给定一个数组和目标数，返回相加和为目标数target的元素的下标
 */
public class TwoSum {

    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for(int j = len - 1; j > i;j--){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] result = new TwoSum().twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
