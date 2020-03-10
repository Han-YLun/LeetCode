import sun.font.FontRunIterator;

import java.util.*;

/**
 * @author: hyl
 * @date: 2020/03/09
 **/
public class Que1365 {

    /**
     * 暴力
     * 时间复杂度 ： O(N^2)
     * 空间复杂度 ： O(N)
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]){
                    sum++;
                }
            }
            result[i] = sum;
        }
        return result;
    }

    /**
     * 暴力
     * 时间复杂度 ： O(N * log(N))
     * 空间复杂度 ： O(N)
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {

        int len = nums.length;
        Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (!valueIndex.containsKey(nums[i])){
                valueIndex.put(nums[i] , new HashSet<>());
            }
            valueIndex.get(nums[i]).add(i);
        }

        int[] sortArr = Arrays.copyOf(nums , len) , res = new int[len];
        Arrays.sort(sortArr);
        for (int index = len-1; index >=0 ; index--) {
            for (int i : valueIndex.get(sortArr[index])) {
                res[i] = index;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {8 ,1,2,2,3};
        //smallerNumbersThanCurrent1(arr);
    }
    
}
