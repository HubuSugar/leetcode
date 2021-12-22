package edu.hubu.hubuSugar.week05;

/**
 * @author: sugar
 * @date: 2021/12/22
 * @descript: 下一个排列
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int len = nums.length;
        //从右向左找到第一个降序对
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //说明存在这样的降序对
        if (i >= 0) {
            //从右向左找到第一个大于节点i的nums[j]
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swapEle(nums, i, j);
        }
        //不存在，将数组整体翻转
        reverse(nums, i + 1);
    }

    /**
     * 剩余的有序数组的翻转
     *
     * @param nums
     * @param start
     */
    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while(left < right){
            swapEle(nums,left,right);
            left++;
            right--;
        }
    }

    private void swapEle(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 4, 3};
        new NextPermutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
