package edu.hubu.top100.day05;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 移动数组中零的位置
 **/
public class MoveZeros {

    public void moveZeros(int[] nums) {
        int len = nums.length;
        //数组左侧非零元素的起始位置
        int begin = -1;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0){
                int j = i;
                int temp = nums[i];
                while(j > begin + 1){
                    nums[j] = nums[j - 1];
                    j--;
                }
                begin = begin + 1;
                nums[begin] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeros().moveZeros(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
