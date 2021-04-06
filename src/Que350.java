import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: hyl
 * @date: 2021/04/03
 **/
public class Que350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int[] arr = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int index = 0;
        for (int i : nums2) {
            if (hashMap.get(i) != null && hashMap.get(i) > 0) {
                arr[index++] = i;
                hashMap.put(i, hashMap.get(i) - 1);
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }


    /**
     * 排序后使用双指针解决
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 两个数组的交集
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int index1 = 0, index2 = 0;

        int[] arr = new int[nums2.length];
        int start = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                arr[start++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(arr,0,start);
    }

    public static void main(String[] args) {
        System.out.println(new Que350().intersect1(new int[]{0,5,8,7,2,9,7,5},
                new int[]{1,4,8,9}));
    }

}
