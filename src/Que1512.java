/**
 * @author: hyl
 * @date: 2020/09/17
 **/
public class Que1512 {

    /**
     * 暴力,直接for循环
     * 时间复杂度 ： O(N*N)
     * 空间复杂度 ： O(1)
     * @param nums
     * @return
     */
    public int numIdenticalPairs1(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 因为题目给了n * (n – 1) / 2这个提示,所以可以使用先统计每个数出现次数,然后用公式计算
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     * @param nums
     * @return
     */
    public int numIdenticalPairs2(int[] nums) {

        int[] cn = new int[101];
        int count = 0;

        for (int num : nums) {
            cn[num]++;
        }

        for (int i : cn) {
            if (i > 1){
                count += ( i * (i-1) / 2);
            }
        }
        return count;
    }

    /**
     * 假如用 [1,1,1,1] 这样一个数组作为给定输入, 第一次遇到1的时候, 统计数+=0, 第二次遇到1的时候, 统计数+=1, 第三次遇到1的时候, 统计数+=2, 第四次遇到1的时候, 统计数+=3, ( 所有不同的数字都按照这个规律以此类推.... )
     * 最后的统计结果为 0+1+2+3 = 6
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     * @param nums
     * @return
     */
    public int numIdenticalPairs3(int[] nums) {

        int[] cn = new int[100];
        int count = 0;

        for (int num : nums) {
            count += cn[num-1]++;
        }

        return count;
    }
}
