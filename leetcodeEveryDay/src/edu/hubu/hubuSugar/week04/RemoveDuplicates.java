package edu.hubu.hubuSugar.week04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: sugar
 * @date: 2021/12/13
 * @descript: 删除有序数组中重复的数字
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int count = 0;  //用来记录不重复数字的个数，同时也是不重复元素的个数
        int len =nums.length;
        int i = 0;
        while(i < len){
            int j = i + 1;  //指向下一次遍历的位置
            while(j < len && nums[j] == nums[i]){
                j++;
            }
            nums[count++] = nums[i];
            i = j;
        }

        return count;
    }

    /**
     * 这种做法不满足题目要求，对于不重复的元素需要向前移动
     * 经过改造这种方法能够满足题目的要求
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums){
        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        int index = 0;
        int[] temp = new int[map.size()];
        for (Integer integer : map.keySet()) {
            temp[index++] = integer;
        }
        Arrays.sort(temp);
        index = 0;
        for(Integer i:temp){
            nums[index++] = i;
        }
        return map.size();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 1,2, 3, 3, 4, 5}));
    }

}
