/**
 * @author: hyl
 * @date: 2021/05/09
 **/
public class Que73 {

    /**
     * 时间复杂度 ： O(mn)
     * 空间复杂度 : O(mn)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //把行置位0
                    for (int k = 0; k < matrix[0].length; k++) {
                        copy[i][k] = 0;
                    }

                    // 把列置位0
                    for (int k = 0; k < matrix.length; k++) {
                        copy[k][j] = 0;
                    }

                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = copy[i][j];
            }
        }


    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagFirstCol = false, flagFirstRow = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagFirstCol = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flagFirstRow = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (flagFirstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

    }
}
