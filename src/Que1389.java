import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2020/03/29
 **/
public class Que1389 {

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        if (nums == null && index == null){
            return new int[0];
        }

        List<Integer> target = new ArrayList(nums.length);
        for (int i = 0; i < index.length; i++) {

            target.add(index[i] , nums[i]);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < target.size(); i++) {
            res[i] = target.get(i);
        }
        return res;
    }
}
