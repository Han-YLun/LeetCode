/**
 * @author: hyl
 * @date: 2020/09/18
 **/
public class Que1572 {

    /**
     * 对角线相加,然后减去中间重复的
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(1)
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0){
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[mat.length-1-i][i];
        }
        if ((mat.length & 1) != 0){
            sum -= mat[mat.length/2][mat.length/2];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(new Que1572().diagonalSum(arr));

    }
}
