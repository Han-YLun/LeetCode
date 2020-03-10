

import java.util.*;

/**
 * @author: hyl
 * @date: 2019/08/06
 **/
public class Que51 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<List<String>>();

        generate(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);


      
        return res;


    }

    private void generate(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<List<String>> res) {

        if (r == board.length){
            List<String> list = new ArrayList<String>();

            for (int i = 0; i < board.length; i++) {
                list.add(board[i]);
            }
            res.add(list);
        }else{
            for (int c = 0; c < board.length; c++) {

                //id1为撇,id为捺
                int id1 = r - c + board.length, id2 = 2 * board.length - r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]){

                    char[] row = new char[board.length];
                    Arrays.fill(row,'.');
                    row[c] = 'Q';
                    board[r] = new String(row);

                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;

                    generate(r+1 , cols , d1 , d2 , board , res);

                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Que51().solveNQueens(4);
    }

}
