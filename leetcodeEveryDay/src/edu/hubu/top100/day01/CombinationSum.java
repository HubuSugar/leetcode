package edu.hubu.top100.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-06
 * @Description: 组合总和
 **/
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        //防止重复元素，先对数组排序
        Arrays.sort(candidates);
        backTracing(candidates, 0, new LinkedList<>(), target, 0, result);
        return result;
    }

    /**
     * 回溯法 + 剪枝操作
     * 7
     * /  \
     * 2    3
     *
     * @param candidates
     * @param pathSum
     * @param path       树形结构的每一条
     * @param target
     * @param startIndex : 防止重复，因为已经对候选数组进行了排序，所以每次对当前下标（包含）和之后的元素进行筛选
     */
    public void backTracing(int[] candidates, int pathSum, List<Integer> path, int target, int startIndex, List<List<Integer>> result) {
        if (pathSum == target) {
            //找到了满足条件的一组元素
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(pathSum + candidates[i] <= target){
                path.add(candidates[i]);
                backTracing(candidates, pathSum + candidates[i], path, target, i, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(new CombinationSum().combinationSum(candidates, 7));
    }
}
