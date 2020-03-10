import java.util.Arrays;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/08/12
 **/
public class Que300 {



    //时间复杂度为O(N * logN),空间复杂度为O(N)
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] res = new int[nums.length];

        res[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > res[index]){
                res[++index] = nums[i];
            }else{
                int indexNum = Arrays.binarySearch(res, 0, index, nums[i]);

                if (indexNum >= 0){
                    res[indexNum] = nums[i];
                }else{
                    //如果没找到,返回的是 -(mid + 1)
                    //需要看下二分查找的源码,这点有点坑，
                    //希望大家尽量可以使用自己写的,可以自定义自己返回的值
                    res[-indexNum-1] = nums[i];
                }
            }
        }

        return index+1;
    }

    //dp求解
    //时间复杂度为O(N * N),空间复杂度为O(N)
    public int lengthOfLIS1(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int result = 1;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
            result = Math.max(dp[i] , result);
        }
        

       return result;
    }

    public static void main(String[] args) {
        new Que300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }


}
