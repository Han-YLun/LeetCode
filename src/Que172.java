/**
 * @author: hyl
 * @date: 2021/04/09
 **/
public class Que172 {

    /**
     * 如果要出现10,则为2*5,在阶乘里面,出现2的次数完全大于5出现的次数,即统计5出现的次数即可
     * 每隔5个数就会多出1个5
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n / 5 + n / 25 + n / 125 + n / 625 + n / 3125 + n / 15625 + n / 78125 + n / 390625 + n / 1953125 +
                n / 9765625 + n / 48828125 + n / 244140625 + n / 1220703125;
    }

    /**
     * 将解法1翻译出来即为如此
     *
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return n;
    }
}
