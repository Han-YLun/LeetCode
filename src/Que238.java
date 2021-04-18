/**
 * @author: hyl
 * @date: 2021/04/18
 **/
public class Que238 {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = 0; j < nums.length; j++) {
                if ( i == j){
                    continue;
                }
                sum *= nums[j];
            }
            res[i] = sum;
        }
        return res;

    }
}
