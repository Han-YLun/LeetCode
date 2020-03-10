import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que1 {


    //解法一
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

    //解法二
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {

            int contain = target - nums[i];

            if (map.containsKey(contain) && map.get(contain) != i){
                return new int[]{i,map.get(contain)};
            }
        }

        return null;
    }

    //解法三
    public int[] twoSum3(int[] nums, int target) {

       Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {



            int contain = target - nums[i];

            if (map.containsKey(contain)){
                return new int[]{map.get(contain),i};
            }

            map.put(nums[i],i);
        }

        return null;
    }
}
