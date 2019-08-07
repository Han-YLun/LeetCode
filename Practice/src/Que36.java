import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2019/08/07
 **/
public class Que36 {

    //暴力,时间复杂度为O(N^2)
    public boolean isValidSudoku(char[][] board) {

        int[] result = new int[10];

        //判断行是否合法
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != '.'){
                    result[board[i][j] - '0']++;
                }
            }

            for (int k = 0; k < result.length; k++) {

                if (result[k] > 1){
                    return false;
                }
            }

            Arrays.fill(result,0);
        }


        //判断列是否合法
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.'){
                    result[board[j][i] - '0']++;
                }
            }

            for (int k = 0; k < result.length; k++) {

                if (result[k] > 1){
                    return false;
                }
            }

            Arrays.fill(result,0);
        }

        //判断每个3x3的宫格内是否合法
        int row = 0 , col = 0;
        while (row < 9){

            for (int i = row; i <row+3 ; i++) {
                for (int j = col; j < col+3; j++) {
                    if (board[i][j] != '.'){
                        result[board[i][j] - '0']++;
                    }
                }
            }

            for (int i = 0; i < result.length; i++) {

                if (result[i] > 1){
                    return false;
                }
            }

            Arrays.fill(result,0);

            col += 3;
            if (col >= 9){
                row += 3;
                col = 0;
            }


        }

        return true;
    }

}
