/**
 * @author: hyl
 * @date: 2019/08/07
 **/
public class Que37_Error {

    public void solveSudoku(char[][] board) {

       solve(board);

    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.'){
                    for (char c = '1';c <= '9';c++) {

                        if (isVaild(board,i,j,c)){
                            board[i][j] = c;

                            if (solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isVaild(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            //检查行
            if (board[i][col] != '.' && board[i][col] == c){
                return false;
            }

            //检查列
            if (board[row][i] != '.' && board[row][i] == c){
                return false;
            }

            //检查3*3
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){
                return false;
            }
        }
        return true;
    }
}
