package edu.hubu.top100.day01;

/**
 * @author: sugar
 * @date: 2022/3/5
 * @description: 接雨水
 */
public class Trap {


    /**
     * 双指针 time O(n) space: O(1)
     * 1、定义左右两个指针
     * 2、
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = 0, right_max = 0;
        int result = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > left_max){
                    left_max = height[left];
                }else{
                    result += left_max - height[left];
                }
                left++;
            }else{
                if(height[right] > right_max){
                    right_max = height[right];
                }else{
                  result += right_max - height[right];
                }
                right--;
            }
        }
        return result;
    }

    /**
     * 单调递减栈
     * @param args
     */


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trap().trap(height));

        int[] height1 = {4,2,0,3,2,5};
        System.out.println(new Trap().trap(height1));
    }
}
