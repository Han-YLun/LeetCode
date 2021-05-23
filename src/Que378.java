import sun.nio.cs.ext.MacArabic;

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
     *
     * @param matrix 矩阵
     * @param k      排序后的第 k 小元素
     * @return 排序后的第 k 小元素
     */
    public int kthSmallest(int[][] matrix, int k) {

        int size = matrix.length;
        int len = matrix[0].length;
        int[] arr = new int[size * len];
        int index = 0;
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < len; j++) {
                arr[index++] = matrix1[j];
            }
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }

    /**
     * 直接将矩阵放到数组中,然后排序后查询第K小元素即可
     * 时间复杂度 ： O(N * N * logN)
     * 空间复杂度 : O(N * N)
     *
     * @param matrix 矩阵
     * @param k      排序后的第 k 小元素
     * @return 排序后的第 k 小元素
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int size = matrix.length;
        int len = matrix[0].length;

        //最小值
        int left = matrix[0][0];
        //最大值
        int right = matrix[size - 1][len - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, size)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int size) {

        int i = size - 1;
        int j = 0;
        int num = 0;
        while ( (i >= 0) && (j <size)){
            if (matrix[i][j] <= mid){
                num += (i+1);
                j++;
            }else{
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] matrix  = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new Que378().kthSmallest1(matrix,8));
    }

}
