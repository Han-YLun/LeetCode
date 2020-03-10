import java.util.Arrays;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        int count = 1;
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (value == nums[i]){
                count++;
            }else{
                count--;
            }


            if (count == 0){
                value = nums[i];
                count = 1;
            }
        }
        return value;

    }


}
