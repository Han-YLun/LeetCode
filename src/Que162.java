/**
 * @author: hyl
 * @date: 2021/05/10
 **/
public class Que162 {
    public int findPeakElement(int[] nums) {

        //处理只有一个的情况
        if(nums.length < 2){
            return 0;
        }

        //处理有两个的情况
        if (nums.length == 2){
            if (nums[0] < nums[1]){
                return 0;
            }else{
                return 1;
            }
        }

        for (int i = 1; i < nums.length-1; i++) {

            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }

        //处理当峰值是最后一个元素的时候
        if (nums[nums.length-1] > nums[nums.length-2] && nums[nums.length-1] > nums[0]){
            return nums.length-1;
        }
        return 0;
    }
}
