package edu.hubu.top100.day05;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-05
 * @Description: 编辑距离
 **/
public class MinDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if(m == 0 || n == 0){
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }

        for(int j = 0;j < n + 1;j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1;j++){
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int left_top = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    left_top += 1;
                }
                dp[i][j] = Math.min(Math.min(left, top),left_top);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
       String word1 = "intention", word2 = "execution";
        System.out.println(new MinDistance().minDistance(word1, word2));
    }

}
