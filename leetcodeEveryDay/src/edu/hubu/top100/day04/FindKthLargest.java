package edu.hubu.top100.day04;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 寻找第K大元素
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(int num : nums){
            //先加入再判断
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new FindKthLargest().findKthLargest(nums, 2));
    }
}
