import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/03
 **/
public class Que350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if(nums1 == null || nums2 == null){
            return null;
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }

        for (int i : nums2) {
            if (hashMap.get(i)!= null && hashMap.get(i) > 0){
                list.add(i);
                hashMap.put(i,hashMap.get(i)-1);
            }
        };
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
