package edu.hubu.hubuSugar.week01;

/**
 * @Author: huxiaoge
 * @Date: 2021-10-08
 * @Description: 两个正序数组的中位数（Hard）
 **/
public class FindMedianSortedArrays {

    /**
     * 基于二分查找
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2,nums1);
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        //左边元素的个数(i + j 始终满足以下条件)
        int totalLeft = (m + n + 1) / 2;
        //  在0到m的区间进行二分查找
        int left = 0;
        int right = m;

        int leftValue = 0;
        int rightValue = 0;

        while(left <= right){
            // 将nums1和nums2的前半部分合并起来， 前一部分包括 nums1[0,1,2...i- 1] 和nums2[0,1,2...j - 1]
            int i = (left + right) / 2;
            int j = totalLeft - i;
            //考虑边界情况

            //nums1LeftMax,nums2LeftMax,分别表示两个数组分割线左边的最大值和右边的最小值，如果到了数组左边界那么取值min_value，如果到了数组的右边界那么取值max_value
            int nums1LeftMax = (i == 0 ? min : nums1[i - 1]);
            int nums1Rightmin = (i == m ? max : nums1[i]);

            int nums2LeftMax = (j == 0 ? min : nums2[j - 1]);
            int nums2Rightmin = (j == n ? max : nums2[j]);

            if(nums1LeftMax <= nums2Rightmin){

                leftValue = Math.max(nums1LeftMax,nums2LeftMax);
                rightValue = Math.min(nums1Rightmin,nums2Rightmin);
                //说明i还可以向右移动
                left = i + 1;
            }else{
                //将搜索范围压缩到 left  到 i - 1
                right = i - 1;
            }


        }


        return (m + n) % 2 == 1 ? leftValue : (leftValue + rightValue) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5};
        int[] nums2 = new int[]{1,3,4};
        double medianNum = new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianNum);
    }
}
