import java.util.Arrays;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int index = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums [i] > max){
                index = i;
                max = nums [i];
            }
        }


        Arrays.sort(nums);

        if (nums[nums.length-1] >= nums[nums.length-2] * 2){
            return index;
        }
        return -1;
    }
}
