package edu.hubu.top100.day04;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-03
 * @Description:
 **/
public class NumIslands {

    /**
     * 深度优先搜索遍历
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        int length = grid.length;
        int height = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, length, height);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int length, int height) {
        if (i < 0 || j < 0 || i >= length || j >= height || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, length, height);
        dfs(grid, i - 1, j, length, height);
        dfs(grid, i, j + 1, length, height);
        dfs(grid, i, j - 1, length, height);
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NumIslands().numIslands(grid));
    }
}
