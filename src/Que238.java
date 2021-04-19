
/**
 * @author: hyl
 * @date: 2021/04/18
 **/
public class Que238 {

    /**
     * 先计算出i左边所有的乘积和i右边所有的乘积,然后计算
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        //计算左边的
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        //计算右边的
        right[right.length-1] = 1;
        for (int i = right.length-2; i >=0; --i) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    /**
     * 因为返回的不算O(N),可以先把left的结果放到返回数组中,然后从右向左即可
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {


        int[] res = new int[nums.length];

        //计算左边的
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int rightMulSum = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            res[i] *= rightMulSum;
            rightMulSum *= nums[i];
        }

        return res;
    }

}
