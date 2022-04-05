package edu.hubu.hubuSugar.extend;

/**
 * @author: sugar
 * @date: 2022/4/5
 * @description: 归并排序
 */
public class MergeSort {

    public  int[] mergeSort(int[] nums,int left,int right){
        if(left == right) return new int[]{nums[left]};
        int mid = (left + right - 1) / 2;
        int[] leftArr = mergeSort(nums,left, mid);
        int[] rightArr = mergeSort(nums,mid + 1, right);
        int[] merged = new int[leftArr.length + rightArr.length];
        int m = 0, i = 0, j = 0;
        while(i < leftArr.length && j < rightArr.length){
            merged[m++] = leftArr[i] > rightArr[j] ? rightArr[j++] : leftArr[i++];
        }
        while(i < leftArr.length){
            merged[m++] = leftArr[i++];
        }
        while(j < rightArr.length){
            merged[m++] = rightArr[j++];
        }
        return merged;
    }

    public int[] merge(int[] nums){
        return mergeSort(nums,0,nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,5,6,7,8,4,2,3,1};
        int[] merge = new MergeSort().merge(nums);
        for (int i : merge) {
            System.out.println(i);
        }
    }

}
