import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Han-YLun
 * @date 2019/6/2 0002
 * @Version 1.0
 */
public class Que4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        List<Integer> list = new ArrayList<Integer>();

        int num1Index = 0, num2Index = 0;

        while (num1Index < nums1.length && num2Index < nums2.length){

            if (nums1[num1Index] >= nums2[num2Index]){
                list.add(nums2[num2Index++]);
            }else{
                list.add(nums1[num1Index++]);
            }
        }


        if (num1Index >= nums1.length){
            for (int i = num2Index; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        }

        if (num2Index >= nums2.length){
            for (int i = num1Index; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }

        if (list.size() % 2 != 0){
            return list.get(list.size() / 2);
        }else{
            System.out.println((list.get(list.size() / 2) + list.get((list.size() / 2) - 1)));
            return (list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) * 1.0 / 2;
        }


    }
    public static void main(String[] args) {
        Que4 que4 = new Que4();
        double medianSortedArrays = que4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        System.out.println(medianSortedArrays);
    }
}
