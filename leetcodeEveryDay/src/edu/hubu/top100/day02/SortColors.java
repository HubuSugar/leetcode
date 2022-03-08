package edu.hubu.top100.day02;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-08
 * @Description: 红白蓝三种颜色分类
 **/
public class SortColors {

    /**
     * 快速排序的思想
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 1) return;

        //区间【p0, i)  =  0
        //区间【 i, p2)  = 1
        //区间 (p2, len - 1) = 2
        int p0 = 0;
        int p2 = len - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        new SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
