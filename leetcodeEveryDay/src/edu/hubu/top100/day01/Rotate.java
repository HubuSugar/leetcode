package edu.hubu.top100.day01;

/**
 * @author: sugar
 * @date: 2022/3/6
 * @description: 二维数组旋转
 */
public class Rotate {

    /**
     * 我的想法是以[i][j]这个坐标点为突破口
     * [i][j] 这个点旋转之后将会覆盖 [j][n - 1 - i]这个点，为防止点的值被覆盖，
     * 所以先暂存[j][ n - 1 - i]这个点的值
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new Rotate().rotate(matrix);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
