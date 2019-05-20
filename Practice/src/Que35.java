/**
 * @Author: Han-YLun
 * @date 2019/5/10 0010
 * @Version 1.0
 */
public class Que35 {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums [i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
