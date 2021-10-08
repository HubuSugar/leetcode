package edu.hubu.hubuSugar.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huxiaoge
 * @Date: 2021-09-28
 * @Description: 最长子串
 **/
public class LengthOfLongestSubstring {

    /**
     * 基于滑动窗口时间复杂度o(n), 空间复杂度o(m)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;
        //记录每次最长的子串
        int max = 0;
        //记录每次的起始位置
        int left = 0;
        //用于存储每个字符最新的下标位置
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int length = new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }

}
