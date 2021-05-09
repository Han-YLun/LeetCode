import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: hyl
 * @date: 2021/05/09
 **/
public class Que215 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ints.sort((Comparator<Object>) (o1, o2) -> (Integer) o2 - (Integer) o1);
        return  ints.get(k - 1);
    }

    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }



    public static void main(String[] args) {
        System.out.println(new Que215().findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
