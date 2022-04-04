package edu.hubu.top100.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 寻找数组中重复的数字
 **/
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            if(count.containsKey(num)){
                return num;
            }else {
                count.put(num,1);
            }
        }
        return -1;
    }

    /**
     * 快慢指针，判断链表是否存在环
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums){
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,3,2};
        System.out.println(new FindDuplicate().findDuplicate1(nums));
    }
}
