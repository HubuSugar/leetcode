package edu.hubu.hubuSugar.week01;

/**
 * @Author: huxiaoge
 * @Date: 2021-10-08
 * @Description: 两个正序数组的中位数（Hard）
 **/
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumLen = 0;
        if(nums1 == null && nums2 == null){
            return 0;
        }
        if(nums1 == null || nums1.length == 0){
            int len2 = nums2.length;
            if(len2 == 0){
                return 0;
            }
            //为偶数
            if(len2 % 2 == 0){
                int start = len2 / 2;
                int end = start - 1;
                return (nums2[start] + nums2[end]) / 2.0;
            }else{
                int mid = len2 / 2;
                return nums2[mid];

            }
        }

        if(nums2 == null || nums2.length == 0){
            int len1 = nums1.length;
            //为偶数
            if(len1 % 2 == 0){
                int start = len1 / 2;
                int end = start - 1;
                return (nums1[start] + nums1[end]) / 2.0;
            }else{
                int mid = len1 / 2;
                return nums1[mid];

            }
        }


        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1,3,4};
        double medianNum = new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianNum);
    }
}
