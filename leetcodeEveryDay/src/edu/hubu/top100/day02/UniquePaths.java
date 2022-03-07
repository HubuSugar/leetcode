package edu.hubu.top100.day02;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-07
 * @Description: 机器人的运动路径
 **/
public class UniquePaths {


    /**
     * 当前格子的路径 = 左边格子的路径和 + 上方格子的路径和
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] total = new int[m][n];
        for (int i = 0; i < m; i++) {
            total[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            total[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                total[i][j] = total[i - 1][j] + total[i][j - 1];
            }
        }
        return total[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

}
