package edu.hubu.hubuSugar.week01;

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
}
