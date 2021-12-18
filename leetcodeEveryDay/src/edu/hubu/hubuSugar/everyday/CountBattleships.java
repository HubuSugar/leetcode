package edu.hubu.hubuSugar.everyday;

/**
 * @author: sugar
 * @date: 2021/12/18
 * @descript: 停靠战舰的数量-419-middle
 */
public class CountBattleships {

    public int countBattleships(char[][] board){
        if(board == null || board.length == 0) return 0;
        int count = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == 'X'){
                    if(i > 0 && board[i - 1][j] == 'X'){
                        continue;
                    }
                    if(j > 0 && board[i][j - 1] == 'X'){
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new char[]{'X','.','.','X'};
        board[1] = new char[]{'.','.','.','X'};
        board[2] = new char[]{'.','.','.','X'};
        System.out.println(new CountBattleships().countBattleships(board));
    }
}
