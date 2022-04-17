package edu.hubu.top100.day05;

/**
 * @author: sugar
 * @date: 2022/4/17
 * @description: 数组的最长严格递增的子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;

        int[] dp = new int[length];
        dp[0] = 1;

        int maxLength = 0;

        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    /**
     * 贪心算法 + 二分搜索
     * 我们期望每次放到递增子数组的最后一个元素都尽可能的小，使得递增的子序列增长尽可能慢
     * 如果当前遍历的元素nums[i] 大于子数组的最后一个元素，那么将这个元素放到递增子序列中
     * 否则的话从递增子序列中找到第一个大于nums[i]的元素进行替换
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums){
        int length = nums.length;
        if(length == 1) return 1;
        int len = 1;
        int[] d = new int[length + 1];
        d[len] = nums[0];
        for(int i = 1; i < length; i++){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else{
                //通过二分搜索查找第一个大于nums[i]的元素
                int left = 1, right = len, pos = 0;
                while(left <= right){
                    int mid = (left + right) >> 1;
                    if(d[mid] < nums[i]){
                        pos = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LengthOfLIS().lengthOfLIS1(nums));

        int[] nums1 = {0, 1, 0, 3, 2, 3};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums1));

        int[] nums2 = {4, 10, 4, 3, 8, 9};
        System.out.println(new LengthOfLIS().lengthOfLIS1(nums2));
    }
}
