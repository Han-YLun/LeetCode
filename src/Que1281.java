/**
 * @author: hyl
 * @date: 2020/03/29
 **/
public class Que1281 {

    /**
     * 一个while循环，分别乘以和加上n%10的余数，最后相减
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        if (n < 10){
            return 0;
        }
        int sum = 0;
        int mul = 1;
        while (n > 0){
            int temp = n % 10;
            sum += temp;
            mul *= temp;
            n /= 10;
        }
        return mul - sum;
    }
}
