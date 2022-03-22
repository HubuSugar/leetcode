package edu.hubu.top100.day01;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: sugar
 * @date: 2022/3/5
 * @description: 给定一个数组和目标数，返回相加和为目标数target的元素的下标
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //排序加上双指针
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0;i < length;i++){
            indexMap.put(nums[i],i);
        }
        Arrays.sort(nums);
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = indexMap.get(nums[left]);
                result[1] = indexMap.get(nums[right]);
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
        public static void main(String[] args){
            int[] nums = {7,2, 5, 11, 15};
            int target = 18;
            int[] result = new TwoSum().twoSum1(nums, target);
            for (int i : result) {
                System.out.println(i);
            }
        }

    }
