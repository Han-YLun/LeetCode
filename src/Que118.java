import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[][] fib = new int[numRows][numRows];
        if (numRows == 0){
            return result;
        }


        fib[0][0] = 1;
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if(j== 0 || j==numRows-1){
                    fib[i][j] = 1;
                }else{
                    fib[i][j] = fib[i-1][j] + fib[i-1][j-1];
                }
            }
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                list.add(fib[i][j]);
            }
            result.add(list);
        }


        return result;
    }

    public static void main(String[] args) {
        Que118 que118 = new Que118();
        que118.generate(5);
    }
}
