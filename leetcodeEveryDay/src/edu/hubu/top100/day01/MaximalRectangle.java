package edu.hubu.top100.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-06
 * @Description:
 **/
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int area = 0;
        for (int i = 0; i < m; i++) {
            int[] heights = new int[n];
            //按每一行每一行统计柱状图的大小
            loop1:
            for (int x = 0; x < n; x++) {
                int height = 0;
                for (int y = i; y >= 0; y--) {
                    if(matrix[y][x] == '1'){
                        height++;
                    }else{
                        heights[x] = height;
                        continue loop1;
                    }
                }
                heights[x] = height;
            }
            area = Math.max(area, helper(heights));
        }
        return area;
    }

    public int helper(int[] heights) {
        int area = 0;
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (newHeights[stack.peekLast()] > newHeights[i]) {
                int height = newHeights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] test = {3,1,3,2,2};
        System.out.println(new MaximalRectangle().helper(test));

        // char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        // System.out.println(new MaximalRectangle().maximalRectangle(matrix));

        char[][] matrix1 = {{'1','0'},{'0','1'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix1));

    }

}
