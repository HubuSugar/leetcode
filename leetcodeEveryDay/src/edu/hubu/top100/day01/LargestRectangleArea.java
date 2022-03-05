package edu.hubu.top100.day01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: sugar
 * @date: 2022/3/5
 * @description: 最大矩形的面积
 */
public class LargestRectangleArea {

    /**
     * 暴力
     * 向两边遍历数组，找到左边和右边第一个严格小于当前高度，那么以当前下标为高度的面积就是当前的最大面积
     * time: O(n)
     */
    public int largestRectangleArea0(int[] heights) {
        int area = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {

            int j = 0, k = 0;
            for (j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
            }

            for (k = i + 1; k < len; k++) {
                if (heights[k] < heights[i]) {
                    break;
                }
            }
            area = Math.max(area, (k - j - 1) * heights[i]);
        }
        return area;
    }

    /**
     * 单调递减栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int width = 0;
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            area = Math.max(area, width * height);
        }

        return area;
    }


    /**
     * 单调递减栈 + 哨兵sentinel
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaWithSentinel(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int area = 0;
        len += 2;
        int[] newHeights = new int[len];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);   //添加哨兵
        for (int i = 1; i < len; i++) {
            while (newHeights[stack.peekLast()] > newHeights[i]) {
                //此处会有栈顶元素的变化
                int height = newHeights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }


    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(heights));

        int[] heights1 = {2, 2, 2};
        System.out.println(new LargestRectangleArea().largestRectangleArea0(heights1));

        int[] heights2 = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea().largestRectangleAreaWithSentinel(heights2));
    }
}
