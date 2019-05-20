/**
 * @Author: Han-YLun
 * @date 2019/5/10 0010
 * @Version 1.0
 */
public class Que485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                sum += 1;
            }else{
                sum = 0;
            }
        }

        return 0;
    }
}
