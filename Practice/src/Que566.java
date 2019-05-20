import java.util.concurrent.ForkJoinPool;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int start=0,end = 0;

        if((r * c) != (nums.length * nums[0].length)){
            return nums;
        }else{
            int[][] result = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    if (end >= nums[0].length){
                        start++;
                        end = 0;
                    }
                    result[i][j] = nums[start][end++];
                }
            }
            return result;
        }
    }
}
