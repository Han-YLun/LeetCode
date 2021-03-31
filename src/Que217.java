import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyl
 * @date: 2021/03/31
 **/
public class Que217 {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0){
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate1(int[] nums) {

        if (nums == null || nums.length == 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }

}
