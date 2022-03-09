package edu.hubu.top100.day02;

import com.sun.org.apache.xpath.internal.objects.XString;

/**
 * @author: sugar
 * @date: 2022/3/9
 * @description: 二维矩阵中是否存在目标字符串
 */
public class Exist {
    public int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int w = word.length();
        char[] chars = word.toCharArray();

        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {
                    used[i][j] = true;
                    if (match(board, chars, used, m, n, w, i, j, 1)) {
                        return true;
                    } else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    public boolean match(char[][] board, char[] words, boolean[][] used, int m, int n, int w, int i, int j, int index) {
        if (index == w) {
            return true;
        }

        for(int[] direct: directions){
            int newX = i + direct[0];
            int newY = j + direct[1];
            if(newX < 0 || newX >= m || newY < 0||newY >= n){
                continue;
            }
            if (used[newX][newY] || words[index] != board[newX][newY]) {
                continue;
            }
            used[newX][newY] = true;
            if(match(board,words,used,m,n,w,newX,newY,index+1)){
                return true;
            }else{
                used[newX][newY] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String words = "ABCB";
        System.out.println(new Exist().exist(chars, words));
    }

}
