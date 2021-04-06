/**
 * @author: hyl
 * @date: 2021/04/05
 **/
public class Que53 {

    /**
     * 求最大的子连续和问题
     * 动态规划,其实就是求f(i-1)加上当前位置是f(i-1)大还是当前位置的大
     *
     * @param nums 数组
     * @return 最大自连续和
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int preSum = 0, maxSum = nums[0];

        for (int num : nums) {
            preSum = Math.max(preSum + num, num);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int preSum = 0, maxSum = nums[0];

        for (int num : nums) {
            preSum = Math.max(preSum + num, num);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }



}
