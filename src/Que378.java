import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2021/05/23
 **/
public class Que378 {

    /**
     * 直接将矩阵放到数组中,然后排序后查询第K小元素即可
     * 时间复杂度 ： O(N)
     * 空间复杂度 : O(N)
     * @param matrix    矩阵
     * @param k 排序后的第 k 小元素
     * @return  排序后的第 k 小元素
     */
    public int kthSmallest(int[][] matrix, int k) {

        int size = matrix.length;
        int len = matrix[0].length;
        int[] arr = new int[size * len];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < len; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);
        return arr[k-1];
    }
}
