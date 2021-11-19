package edu.hubu.hubuSugar.week03;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-19
 * @Description: 最接近的三数之和
 **/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) return 0;
        int gap = Integer.MAX_VALUE;
        int res = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            int start = i + 1;
            int end = len - 1;
            int current = nums[i];
            while(start < end){
                int sum = nums[start] + nums[end] + current;
                if(Math.abs(sum - target) < gap){
                    gap = Math.abs(sum - target);
                    res = nums[start] + nums[end] + current;
                }
                if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {

        int i = new ThreeSumClosest().threeSumClosest(new int[]{0,0,0,0}, 2);
        System.out.println(i);

    }
}
