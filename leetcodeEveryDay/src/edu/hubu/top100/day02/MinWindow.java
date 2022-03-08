package edu.hubu.top100.day02;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-08
 * @Description: 最小覆盖子串
 **/
public class MinWindow {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] tFreq = new int[128];
        //滑动窗口子串的词频数组
        int[] winFreq = new int[128];

        for (char c : charArrayT) {
            tFreq[c]++;
        }
        //滑动窗口中出现的t的字符的个数，对应字符频数超过不重复计算
        int distance = 0;
        //最小子串的长度
        int minLen = sLen + 1;
        //  最小子串出现对应的起始位置
        int begin = 0;

        //滑动窗口的左右边界
        int left = 0;
        int right = 0;
        //将右边界向右移动
        while (right < sLen) {
            //子串中出现了t中没有出现的字符
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            //当滑动窗口中当前位置字符的个数严格小于t中元素的个数时distance继续增加
            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }
            //滑动窗口中字符的频数加1
            winFreq[charArrayS[right]]++;
            right++;
            while (distance == tLen) {

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                //如果当前左边界看到的元素不在t中出现，那么缩小左边界
                if (tFreq[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }
                //左边界元素的个数已经减少为刚好等于t中要求的个数
                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]) {
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }
        if (minLen == sLen + 1) return "";
        return s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "BAC";
        System.out.println(new MinWindow().minWindow(s, t));
    }
}
