/**
 * @author: hyl
 * @date: 2021/04/06
 **/
public class Que26 {

    /**
     * 将相同的数前面的全部置为整数的最小值作为标记
     * 然后将非整数最小值向前填充,如果数组出现整数最小值,则会出现问题
     * @param nums 数组
     * @return  数组长度
     */
    public int removeDuplicates(int[] nums) {
        int length = 0;
        if(nums == null || nums.length == 0){
            return length;
        }

        for (int i = 1; i < nums.length; i++) {
            //如果相邻两个相等,把前面的置为最小值
            if (nums[i-1] == nums[i]){
                nums[i-1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE){
                nums[length++] = nums[i];
            }
        }
        return length;
    }

    /**
     * 使用双指针
     * @param nums 数组
     * @return  数组长度
     */
    public int removeDuplicates1(int[] nums) {
        int length = 0;
        if(nums == null || nums.length == 0){
            return length;
        }

        int cur = 0, index=0;
        while (index< nums.length){
            if (nums[index] == nums[cur]){
                index++;
            }else{
                nums[++cur] = nums[index++];
            }
        }
        return cur+1;
    }

}
