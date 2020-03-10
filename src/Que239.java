import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/01
 **/
public class Que239 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k > nums.length){
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        int index = 0;

        for (int i = 0; i < nums.length - k; i++) {
            
            int max = nums[i];

            for (int j = i+1; j < k+i; j++) {
                if (max < nums[j]){
                    max= nums[j];
                }
            }

         result[index++] = max;
        }

        return result;
    }



    public int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums == null || nums.length < 2){
            return nums;
        }
        
        //保存当前窗口最大值的数组位置
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int[] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {

            //保存从大到小,如果后面的比前面大,就依次弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }

            queue.addLast(i);

            //如果当前队首是已移动窗口,则弹出
            if (queue.peek() <= i-k){
                queue.poll();
            }

            //当窗口长度为K时,保存结果
            if (i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int[] ints = new Que239().maxSlidingWindow(
                new int[]{1,3,-1,-3,5,3,6,7}
                ,3);
        System.out.println(ints);
    }
}
