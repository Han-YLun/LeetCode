import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2021/05/12
 **/
public class Que34 {

    /**
     * 时间复杂度 : O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return pos;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }

            if (target == nums[i]) {
                if (pos[0] == -1) {
                    pos[0] = i;
                    pos[1] = i;
                } else {
                    pos[1] = i;
                }
            }
        }
        return pos;
    }

 

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Que34().searchRange(
                new int[]{1, 3}
                , 1)));
    }
}
