/**
 * @author: hyl
 * @date: 2021/03/27
 **/
public class Que136 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
