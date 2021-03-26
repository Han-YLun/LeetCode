/**
 * @author: hyl
 * @date: 2021/03/26
 **/
public class Que191 {
    public int hammingWeight(int n) {

        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                sum += 1;
            }

            //如果已经为0,直接结束
            if (n == 0) {
                return sum;
            }

            n = n >>> 1;
        }
        return sum;
    }

    public int hammingWeight1(int n) {

        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum += 1;
        }
        return sum;
    }

}
