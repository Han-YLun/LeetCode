/**
 * @author: hyl
 * @date: 2019/08/11
 **/
public class Que152 {

    public int maxProduct(int[] nums) {


        int max = Integer.MIN_VALUE , iMax = 1 , iMin = 1;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0){

                int temp = iMax;
                iMax = iMin;
                iMin = temp;

            }

            iMax = Math.max(iMax * nums[i] , nums[i]);
            iMin = Math.min(iMin * nums[i] , nums[i]);

            max = Math.max(max , iMax);

        }

        return max;

    }
}
