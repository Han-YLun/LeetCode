import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: hyl
 * @date: 2021/05/09
 **/
public class Que287 {

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate1(int[] nums) {

        HashMap<Integer,Integer> hashMap = new HashMap<>(nums.length);
        for (int num : nums) {
            if (hashMap.getOrDefault(num,0) > 0) {
                return num;
            }
            hashMap.put(num, 0);
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {

        int slow = 0 , fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        //找到第一次相遇的地方
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //然后找到入环处
        int pre1 = 0, pre2 = slow;
        while (pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    public static void main(String[] args) {
        System.out.println(new Que287().findDuplicate2(new int[]{1,3,4,2,2}));
    }


}
