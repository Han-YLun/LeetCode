/**
 * @author: hyl
 * @date: 2021/04/18
 **/
public class Que48 {

    /**
     * 先对角线调换,然后左右调换位置
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        //先对角线调换
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //进行左右调换
        int count = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= (count/2) ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][count - j];
                matrix[i][count - j] = temp;
            }
        }

    }
}
