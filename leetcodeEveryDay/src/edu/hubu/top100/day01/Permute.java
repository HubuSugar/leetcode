package edu.hubu.top100.day01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-06
 * @Description:
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return new ArrayList<>();
        }
        //
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, stack, used, 0, result, len);
        return result;
    }

    private void dfs(int[] nums, Deque<Integer> stack, boolean[] used, int depth, List<List<Integer>> result, int len) {
        if (stack.size() == len) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                stack.addLast(nums[i]);
                used[i] = true;
                dfs(nums, stack, used, depth + 1, result, len);
                stack.removeLast();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permute().permute(nums));
    }
}
