package edu.hubu.hubuSugar.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-04
 * @Description: 判断一个数字是否是回文数
 **/
public class Palindrome {


    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        while(x != 0){
            int remain = x % 10;
            nums.add(remain);
            x = x / 10;
        }

        return helper(nums);
    }

    /**
     * 判断是否是回文串
     * @param nums
     * @return
     */
    private boolean helper(List<Integer> nums) {
        if(nums.size() == 0){
            return true;
        }
        int i = 0;
        int j = nums.size() - 1;
        while(i <= j){
            int head = nums.get(i);
            int tail = nums.get(j);
            if(head != tail){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Palindrome().isPalindrome(-101);
        System.out.println(result);
    }

}
