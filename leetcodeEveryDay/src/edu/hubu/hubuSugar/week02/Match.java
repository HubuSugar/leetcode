package edu.hubu.hubuSugar.week02;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-04
 * @Description: 字符串是否是通配符
 **/
public class Match {

    //DP 使用动态规划
    public boolean isMatch(String s,String p){
        if(s == null || s.length() == 0){
            return false;
        }
        if(p == null || p.length() == 0){
            return false;
        }
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(int i = 0; i <= sLen; i++){
            for(int j = 1;j <= pLen;j++){
                if(ptr[j - 1] != '*'){
                    if(matches(str,ptr,i,j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(matches(str,ptr,i ,j -1)){
                        dp[i][j] = dp[i - 1][j] || dp[i] [j - 2];
                    }else{
                        dp[i][j] = dp[i][j - 2];
                    }
                }

            }
        }
        return dp[sLen][pLen];
    }

    private boolean matches(char[] str,char[] ptr,int i,int j){
        if(i == 0){
            return false;
        }
        if(ptr[j - 1] == '.'){
            return true;
        }
        return str[i - 1] == ptr[j - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Match().isMatch("aab", "a*b"));
    }

}
