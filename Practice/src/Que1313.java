import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2020/03/10
 **/
public class Que1313 {

    /**
     * 暴力,直接填充数
     * 时间复杂度 ： O(N*N)
     * 空间复杂度 ： O(N)
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resList = new ArrayList();
        
        for (int i = 0; i < nums.length-1; i+=2) {
            for (int j = 0; j < nums[i] ; j++) {
                resList.add(nums[i+1]);
            }
        }
        //将list转化为int[]
        int[] resArr = resList.stream().mapToInt(Integer::valueOf).toArray();
        return resArr;
    }

    /**
     * 先计算出返回数组的长度,然后向新数组内填充
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     */
    public int[] decompressRLElist1(int[] nums) {
       int len = nums.length;
       int newLength = 0;

       //偶数位相加即为返回数组的长度
        for (int i = 0; i < nums.length ; i+=2) {
            newLength += nums[i];
        }

        int[] res = new int[newLength];
        int index = 0;
        for (int i = 0; i < len; i+=2) {
            int count = nums[i];
            int value = nums[i+1];
            while (count-- > 0){
                res[index++] = value;
            }
        }
        return res;
    }

}
