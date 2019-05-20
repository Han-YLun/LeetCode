/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que27 {

    public int removeElement(int[] nums, int val) {

        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != Integer.MAX_VALUE){
                nums[index++] = nums[i];
            }
        }

        
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        Que27 que27 = new Que27();
        int i = que27.removeElement(arr, 2);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        System.out.println(i);
    }
}
