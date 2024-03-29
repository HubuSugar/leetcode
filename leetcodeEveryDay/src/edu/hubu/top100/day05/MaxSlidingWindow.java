package edu.hubu.top100.day05;

import edu.hubu.top100.day04.MaximalSquare;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 滑动窗口的最大值
 **/
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return null;
        int[] result = new int[len - k + 1];

        for (int i = 0; i < len - k + 1; i++) {
            for (int j = i; j < len - k + 1; j += k) {
                int[] sub = new int[k];
                int max = nums[j];
                for (int m = 0; m < k; m++) {
                    sub[m] = nums[j + m];
                    max = getMax(sub, k);
                }
                result[j] = max;
            }
        }

        return result;
    }

    public int getMax(int[] nums, int k) {
        int max = nums[0];
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * 双向队列
     * 时间复杂度 O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return null;
        int[] result = new int[len - k + 1];

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {

            //如果前面的数小，则需要依次弹出
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);


            int left = i - k + 1;

            //判断队首的元素是否有效
            while (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            //当滑动窗口的元素超过k, 队首元素即为最大值
            if(i + 1 >= k){
                result[left] = nums[queue.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, 3, 5, 3, 6, 7};
        int[] result = new MaxSlidingWindow().maxSlidingWindow1(nums, 3);
        for (int i : result) {
            System.out.println(i);
        }

        int[] nums1 = {1};
        int[] result1 = new MaxSlidingWindow().maxSlidingWindow1(nums1, 1);
        for (int i : result1) {
            System.out.println(i);
        }
    }
}
