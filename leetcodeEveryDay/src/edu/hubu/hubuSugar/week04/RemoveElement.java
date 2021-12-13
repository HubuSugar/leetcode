package edu.hubu.hubuSugar.week04;

import java.util.Arrays;


/**
 * @author: sugar
 * @date: 2021/12/13
 * @descript: 删除数组中值为当前val的元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        int i = 0;
        while(i < len){
            if(nums[i] == val){
                int j = i + 1;
                while(j < len && nums[j] == val){
                  j++;
                }
                i = j;
            }else{
                nums[count++] = nums[i];
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }
}
