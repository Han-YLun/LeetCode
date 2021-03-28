/**
 * @author: hyl
 * @date: 2021/03/27
 **/
public class Que326 {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    /**
     * n最大为3^19=1162261467
     * @param n
     * @return
     */
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
