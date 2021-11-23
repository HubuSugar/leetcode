package edu.hubu.hubuSugar.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-22
 * @Description: 四个数的和
 **/
public class FourSum {

    /**
     * 参考之前的两数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //返回的结果
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            //第一个数从下一个不重复的数字起
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //第二位数从第一位的下一位开始
            for(int j = i + 1;j < len;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //定义双指针
                int start = j + 1;
                int end = len - 1;
                int twoSum = nums[i] + nums[j];
                //沿用twoSum的思路
                while(start < end){
                    int remain = target - twoSum;
                    //当前头尾指针的两数和
                    int sum = nums[start] + nums[end];
                    if(remain == sum){
                        //找到一组合适的解
                        List<Integer> one =new ArrayList<>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[start]);
                        one.add(nums[end]);
                        res.add(one);
                        //继续寻找下一组,跳过start相同的值
                        while(start < end && nums[start] == nums[start + 1]){
                            start++;
                        }
                        start = start + 1;
                        while(start < end && nums[end] == nums[end-1]){
                            end--;
                        }
                        end = end - 1;
                    }else if(sum < remain){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{-2,-1,0,0,1,2,2,2},0));
    }
}
