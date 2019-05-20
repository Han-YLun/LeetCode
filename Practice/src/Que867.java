/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que867 {

    public int[][] transpose(int[][] A) {

       int[][] result = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A [i].length; j++) {
                result[j][i] = A [i][j];
            }
        }

        return result;
    }
}
