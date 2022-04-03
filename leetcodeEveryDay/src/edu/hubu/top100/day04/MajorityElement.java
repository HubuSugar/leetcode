package edu.hubu.top100.day04;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-02
 * @Description: 数组中的多数元素， 使用hash表和排序数组后返回中间元素方法
 **/
public class MajorityElement {


    /**
     * boyer-moore投票法
     * 思路: 遍历数组, 当前元素与候选元素一致时， 投票数+1
     * 当前元素与候选元素不一致时， 投票数减一，当投票数为时更换候选人，这样遍历完成之后，candidate的值即为半数以上元素
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        // 当前候选人
        int candidate = nums[0], count = 1;
        for (int i = 1; i < length; i++) {
            int  cur = nums[i];
            if (cur == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    candidate = cur;
                }
            }

        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3,2,3}));

    }
}
