import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/11
 **/
public class Que120 {


    public int minimumTotal(List<List<Integer>> triangle) {

        int N = triangle.size();

        int[][] opt = new int[N+1][N+1];

        for (int i = N-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                opt[i][j] = Math.min(opt[i+1][j],opt[i+1][j+1]) + triangle.get(i).get(j);
            }    
        }

        return opt[0][0];
    }


}
