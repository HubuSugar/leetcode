package edu.hubu.hubuSugar.week02;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-07
 * @Description: 盛最多水多的容器
 **/
public class MaxArea {


    //1、暴力破解，超出时间限制
    //时间复杂度：O(n2)
    public int maxArea(int[] height){
        int result = 0;
        if(height == null || height.length <= 1) return result;
        int len = height.length;
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j < len;j++){
                int area = (Math.min(height[i],height[j])) * (j - i);
                result = Math.max(area,result);
            }
        }
        return result;
    }

    //双指针的思路 时间复杂度O(N)
    public int maxArea1(int[] height){
        int result = 0;
        if(height == null || height.length <= 1) return result;
        int len = height.length;
        int i = 0;
        int j = len - 1;
        while(j > i){
            int min = Math.min(height[i],height[j]);
            result = Math.max(min * (j - i),result);
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea1(new int[]{1, 2, 3, 4}));
    }


}
