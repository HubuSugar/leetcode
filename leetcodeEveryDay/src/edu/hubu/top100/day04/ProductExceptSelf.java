package edu.hubu.top100.day04;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 除自身以外，数组中其余数的乘积
 **/
public class ProductExceptSelf {

    /**
     * timeout !!! 时间复杂度为： O(n^2)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for(int i = 0; i < len;i++){

            int left = 1, right = 1;
            for(int j = 0; j < i;j++){
                left *= nums[j];
            }

            for(int k = i + 1; k < len;k++){
                right *= nums[k];
            }

            result[i] = left * right;
        }

        return result;
    }


    /**
     * 时间复杂度 O(n)
     *
     * 1 2 3 4
     * 1 2 3 4
     * 1 2 3 4
     * 1 2 3 4
     *
     * 沿对角线计算， 结果数组 = 左边元素 * 右边元素
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        for(int i = 1; i < len;i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[len - 1] = 1;
        for(int j = len - 2; j >= 0; j--){
            right[j] = right[j + 1] * nums[j + 1];
        }

        for(int i = 0; i < len;i++){
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = new ProductExceptSelf().productExceptSelf1(nums);
        for(int i:ints){
            System.out.println(i);
        }

    }
}
