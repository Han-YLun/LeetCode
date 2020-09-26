import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2020/09/24
 **/
public class Que1502 {

    /**
     * 先使用快排,然后进行看三项中的间隔是否一样
     * 时间复杂度 ： O(N * Log(N))
     * 空间复杂度 ： O(1)
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length == 0){
            return false;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            if ((arr[i+1] - arr[i]) != (arr[i+2] - arr[i+1])){
                return false;
            }
        }
        return true;
        

    }
}
