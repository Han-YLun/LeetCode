import java.util.HashMap;

/**
 * @author: hyl
 * @date: 2021/05/09
 **/
public class Que454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = 0 - (nums3[i]+nums4[j]);
                count += hashMap.getOrDefault(sum,0);
            }
        }

        return count;
    }
}
