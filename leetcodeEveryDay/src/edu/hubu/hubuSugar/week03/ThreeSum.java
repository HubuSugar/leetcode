package edu.hubu.hubuSugar.week03;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-09
 * @Description:
 **/
public class ThreeSum {

    /**
     * 将数据分为以下三种情况：0 、正数、负数
     * 如果和为零：可以分为以下几种情况：1、如果0的个数为 0 个，那么又可以分为：② 两正一负 ③ 两负一正
     *                             2、如果0的个数为 1个，那么就是一正一负（正负数的绝对值相等)
     *                             3、如果0的个数超过两个，那么只能是三个0
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        List<Integer> zeros = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) {
                zeros.add(num);
            } else if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        //1、0的个数超过两个的情况
        if(zeros.size() >= 3){
            result.add(Arrays.asList(0,0,0));
        }

        //2、0的个数为一个
        if(zeros.size() > 0){
            Set<Integer> collect = new HashSet<>(positives);
            collect.forEach(item -> {
                if(negatives.contains(-1 * item)){
                    List<Integer> one = new ArrayList<>();
                    one.add(0);
                    one.add(item);
                    one.add(-1 * item);
                    result.add(one);
                }
            });
        }

        //3、0的个数为零个
        //两正一负
        for(int i = 0;i < positives.size() - 1;i++){
            for(int j = i + 1;j < positives.size();j++){
                int sum = positives.get(i) + positives.get(j);
                if(negatives.contains(-1 * sum)){
                    List<Integer> one = new ArrayList<>();
                    one.add(positives.get(i));
                    one.add(positives.get(j));
                    one.add(-1 * sum);
                    result.add(one);
                }
            }
        }
        //两负一正
        for(int i = 0;i < negatives.size() - 1;i++){
            for(int j = i + 1; j< negatives.size();j++){
                int sum = negatives.get(i) + negatives.get(j);
                if(positives.contains(-1 * sum)){
                    List<Integer> one = new ArrayList<>();
                    one.add(negatives.get(i));
                    one.add(negatives.get(j));
                    one.add(-1 * sum);
                    result.add(one);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
