/**
 * @author: hyl
 * @date: 2020/09/17
 **/
public class Que1470 {

    /**
     * 根据题解提示,需要返回新数据
     * 原数组为[2,5,1,3,4,7],长度为3;结果数组为[2,3,5,4,1,7]
     * 观察数组下标得出结论,第一个如果为1,下一个为1+3
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || n < 1) {
            return null;
        }

        int[] newArr = new int[2 * n];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            newArr[i] = nums[index];
            newArr[i + 1] = nums[index + n];
            index++;
        }
        return newArr;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        new Que1470().shuffle(arr, 4);
    }
}
