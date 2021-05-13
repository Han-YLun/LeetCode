import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/05/13
 **/
public class Que78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> t = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0){
                    t.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(t));
        }
        return res;

    }
}
