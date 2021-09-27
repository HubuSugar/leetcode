package edu.hubu.hubuSugar.week01;

import java.util.Arrays;

public class SumOfTwoNum {

    public int[] twoSum(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];
        for(int i = 0; i < nums.length;i++){
            for(int j = 0;j < nums.length;j++){
                if(j == i){
                    continue;
                }
                if(nums[j] == target - nums[i]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 相比于方法一在第二个for中减少了遍历的次数
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];
        int len = nums.length;

        for(int i = 0; i < len;i++){
            for(int j = len - 1; j > i;j--){
                if(nums[i] + nums[j] == target){
                    System.out.println("i,j;" + i + "-" + j);
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new SumOfTwoNum().twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(ints).forEach(System.out::print);
    }
}
