package edu.hubu.top100.day02;

/**
 * @author: sugar
 * @date: 2022/3/7
 * @description:
 */
public class CanJump {

    /**
     * 每次计算当前可以跳跃到的最远位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        //reach表示能跳到的最远距离
        int reach = 0;
        for (int i = 0; i < len; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new CanJump().canJump(nums));
    }

}
