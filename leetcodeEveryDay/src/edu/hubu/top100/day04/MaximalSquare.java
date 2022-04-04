package edu.hubu.top100.day04;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 返回最大正方形的面积
 **/
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxEdge = 0;

        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    maxEdge = Math.max(dp[i][j], maxEdge);
                }

            }
        }

        return maxEdge * maxEdge;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new MaximalSquare().maximalSquare(grid));
    }

}
