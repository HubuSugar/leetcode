package edu.hubu.top100.day05;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 二维矩阵中的搜索
 **/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = rows - 1, j = 0; i >= 0 && j < cols; ) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new SearchMatrix().searchMatrix(matrix, 25));

    }

}
