/**
 * @author: hyl
 * @date: 2020/09/17
 **/
public class Que1480 {

    /**
     * 水题,从前往后家
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(1)
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        if (nums == null){
            return null;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
