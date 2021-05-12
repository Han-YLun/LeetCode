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

    /**
     * 时间复杂度 : O(logN)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {

        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false);

        if (leftIndex <= rightIndex && rightIndex< nums.length
        && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length-1,ans = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Que34().searchRange1(
                new int[]{5,7,7,8,8,10}
                , 8)));
    }
}
