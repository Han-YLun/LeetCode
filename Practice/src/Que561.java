import java.util.Arrays;

/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que561 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }

        return sum;

    }

    public static void main(String[] args) {

    }
}
