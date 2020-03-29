/**
 * @author: hyl
 * @date: 2020/03/29
 **/
public class Que1295 {

    /**
     * 统计位数为偶数的数字
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            //如果为奇数,则&1为1;如果为偶数,则为0
            if ((getDigitNums(nums[i]) & 1) == 0){
                count++;
            }
        }
        return count;

    }

    /**
     * 获取整数的位数
     * @param n
     * @return
     */
    public int getDigitNums(int n){
        int count = 0;
        while (n > 0){
            count++;
            n /= 10;
        }
        return count;
    }
}
