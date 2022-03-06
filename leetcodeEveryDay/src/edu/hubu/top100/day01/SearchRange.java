package edu.hubu.top100.day01;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-06
 * @Description:
 **/
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //不进行向下取整会出现死循环
            int mid = (left + right + 1) >>> 1;
            int cur = nums[mid];
            if (cur < target) {
                //如果中间位置上的元素的值严格小于target的值，
                // 说明中间位置及左边肯定不是目标元素的最后一个位置
                left = mid + 1;
            } else if (cur == target) {
                //如果中间位置的元素值等于目标元素，说明中间位置前面的元素肯定不是目标元素最后一次出现的位置
                left = mid;
            } else {
                //如果中间位置的元素值严格大于目标元素，那么中间位置及右边肯定不是目标元素的第一个位置
                right = mid - 1;
            }
        }
        return left;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cur = nums[mid];
            if (cur < target) {
                //如果中间位置上的元素的值严格小于target的值，说明中间位置及左边肯定不是目标元素的第一个位置
                left = mid + 1;
            } else if (cur == target) {
                //如果中间位置的元素值等于目标元素，说明目标位置后面的元素肯定不是目标元素第一次出现的位置
                right = mid;
            } else {
                //如果中间位置的元素值严格大于目标元素，那么中间位置及右边肯定不是目标元素的第一个位置
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] range = new SearchRange().searchRange(nums, 8);
        for (int i : range) {
            System.out.println(i);
        }
    }
}
