import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/06
 **/
public class Que52 {

    public int totalNQueens(int n) {

        List<List<String>> res = new ArrayList<List<String>>();

        generate(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);

        return res.size();
    }

    private void generate(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<List<String>> res) {

        if (r == board.length){
            List<String> list = new ArrayList<>();

            for (String s : board) {
                list.add(s);
            }

            res.add(list);
            return;
        }else{

            for (int c = 0; c < board.length; c++) {

                //id1为撇,id为捺
                int id1 = r - c + board.length, id2 = 2*board.length - r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]){

                    char[] row = new char[board.length];
                    Arrays.fill(row,'.');
                    row[c] = 'Q';

                    board[r] = new String(row);

                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;

                    generate(r+1,cols,d1,d2,board,res);

                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;


                }

            }
        }

    }
}
