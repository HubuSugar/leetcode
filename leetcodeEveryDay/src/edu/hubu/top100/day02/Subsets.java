package edu.hubu.top100.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-08
 * @Description:
 **/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        //i表示每次遍历的子集的长度
        for (int i = 0; i <= len; i++) {
            backTracing(nums, new ArrayList<>(), i, result, 0);
        }

        return result;
    }

    /**
     * 每次查找长度为0的子集
     * @param nums
     * @param path 每个子集
     * @param length  子集的长度
     * @param result 最终结果
     * @param start 防止重复，每次从当前下标往后匹配
     */
    public void backTracing(int[] nums, List<Integer> path, int length, List<List<Integer>> result, int start) {
        if (length == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTracing(nums, path,length - 1, result, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(new Subsets().subsets(nums));
    }
}
