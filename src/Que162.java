import com.sun.org.apache.regexp.internal.RE;

import java.awt.event.KeyAdapter;

/**
 * @author: hyl
 * @date: 2021/05/10
 **/
public class Que162 {

    /**
     * 时间复杂度: O(N)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {

        //处理只有一个的情况
        if(nums.length < 2){
            return 0;
        }

        //处理有两个的情况
        if (nums.length == 2){
            if (nums[0] < nums[1]){
                return 0;
            }else{
                return 1;
            }
        }

        for (int i = 1; i < nums.length-1; i++) {

            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }

        //处理当峰值是最后一个元素的时候
        if (nums[nums.length-1] > nums[nums.length-2] && nums[nums.length-1] > nums[0]){
            return nums.length-1;
        }
        return 0;
    }

    /**
     * 时间复杂度: O(N)
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {

        //使用连续的两个元素 nums[j]nums[j] 和 nums[j + 1]nums[j+1] 不会相等
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }

    /**
     * 递归解决
     * 时间复杂度 : O(logN)
     * 空间复杂度 : O(logN)
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        return search(nums,0,nums.length-1);
    }

    private int search(int[] nums, int left, int right) {
        if (left == right){
            return left;
        }

        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid+1]){
            return search(nums,left,mid);
        }else{
            return search(nums,mid+1,right);
        }

    }

    /**
     * 迭代解决
     * 时间复杂度 : O(logN)
     * 空间复杂度 : O(1)
     * @param nums
     * @return
     */
    public int findPeakElement3(int[] nums) {

        int l = 0,r = nums.length-1;
        while (l < r){
            //防止溢出
            int mid = l + (r- l) / 2;
            if (nums[mid] > nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }


}
