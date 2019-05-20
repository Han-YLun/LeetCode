/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que1 {

    public int[] twoSum(int[] nums, int target) {
        int indexI=0,indexJ=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] + nums[j] == target){
                    indexI = i;
                    indexJ = j;
                    break;
                }
            }
        }
        return new int[]{indexI,indexJ};
    }
}
