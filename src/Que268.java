/**
 * @Author: Han-YLun
 * @date 2019/5/10 0010
 * @Version 1.0
 */
public class Que268 {


    //解法一
    public int missingNumber(int[] nums) {
        int[] a = new int[10];
        for (int i = 0; i < nums.length; i++) {
            a[nums [i]] ++ ;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0){
                return i;
            }
        }
        return 0;
    }

    //解法二
    public int missingNumber1(int[] nums) {
        int sum = (nums.length * (nums.length+1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
