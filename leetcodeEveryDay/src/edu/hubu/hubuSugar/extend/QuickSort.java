package edu.hubu.hubuSugar.extend;

/**
 * @author: sugar
 * @date: 2022/4/5
 * @description:
 */
public class QuickSort {

    public int quickSort(int[] nums,int left,int right){
        int base = nums[left];
        while(left < right){
            while(left < right && nums[right] >= base){
                right--;
            }
            nums[left] = nums[right];

            while(left < right && nums[left] <= base){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }

    public void sort(int[] nums,int start,int end){
        if(start < end){
            int index = quickSort(nums, start, end);
            sort(nums, start, index - 1);
            sort(nums, index + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,9,5,6,7,8,4,2,3,1};
        new QuickSort().sort(nums,0,nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
