import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/06
 **/
public class Que52 {

    public int totalNQueens(int n) {

        List<List<String>> res = new ArrayList<List<String>>();

        generate(n,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);

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
                if (!cols[c] )

            }
        }

    }
}
