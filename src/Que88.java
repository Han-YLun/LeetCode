import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2021/04/08
 **/
public class Que88 {

    /**
     * 将nums放到num1后面,然后进行排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n <= 0) {
            return;
        }

        int index = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[index++];
        }

        Arrays.sort(nums1);
    }

    /**
     * 将num1,num2按顺序合并到新数组后,将新数组赋值给num1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        if (n <= 0) {
            return;
        }

        int[] sorted = new int[m + n];
        int indexNum1 = 0, indexNum2 = 0, index = 0;
        while (index < sorted.length) {

            if (indexNum1 == m) {
                sorted[index++] = nums2[indexNum2++];
            } else if (indexNum2 == n) {
                sorted[index++] = nums1[indexNum1++];
            } else if (nums1[indexNum1] < nums2[indexNum2]) {
                sorted[index++] = nums1[indexNum1++];
            } else {
                sorted[index++] = nums2[indexNum2++];
            }
        }

        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 通过num1和nums2进行对比,从后往前,可以不用开辟额外的空间
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        if (n <= 0) {
            return;
        }

        int indexNum1 = m-1, indexNum2 = n-1, index = m + n - 1;
        while (index >= 0) {

            if (indexNum1 < 0) {
                nums1[index--] = nums2[indexNum2--];
            } else if (indexNum2 < 0) {
                nums1[index--] = nums1[indexNum1--];
            } else if (nums1[indexNum1] < nums2[indexNum2]) {
                nums1[index--] = nums2[indexNum2--];
            } else {
                nums1[index--] = nums1[indexNum1--];
            }
        }
    }

}
