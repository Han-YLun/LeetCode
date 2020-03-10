import java.util.Arrays;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que628 {



    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int max1 =  nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3] ;
        int max2 = nums[nums.length-1] * nums[0] * nums[1] ;

        return max1 > max2 ? max1 : max2;
    }
}
