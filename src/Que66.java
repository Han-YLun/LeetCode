import sun.plugin2.main.server.Plugin;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que66 {

    public int[] plusOne(int[] digits) {

        digits[digits.length -1] += 1;

        for (int i = digits.length -1; i > 0; --i) {
            if (digits [i] > 9){
                digits[i] = 0;
                digits[i-1] += 1;
            }
        }
        if (digits[0] < 10){
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Que66 que66 = new Que66();
        que66.plusOne(arr);
    }
}
