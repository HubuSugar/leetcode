package edu.hubu.hubuSugar.week01;

/**
 * @Author: huxiaoge
 * @Date: 2021-10-12
 * @Description: 最长回文子串（Middle）
 **/
public class LongestPalindrome {

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        String result = "";
        int start = 0;
        int end = 0;
        for(int i = 0;i < s.length();i++){
            int l1 = expandedFromCenter(s ,i,i);
            int l2 = expandedFromCenter(s,i,i+1);
            int max = Math.max(l1,l2);
            if(max > result.length()){
                // 注意这里起始位置需要将最大长度减一后再取一半
                start = i - (max - 1) / 2;
                end = i + max / 2;
                result = s.substring(start, end + 1);
            }
        }

        return result;
    }

    private int expandedFromCenter(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public boolean isPalindrome(String s){

        return false;
    }

    public static void main(String[] args) {

        String abba = new LongestPalindrome().longestPalindrome("abceabbad");
        System.out.println(abba);
    }
}
