import java.sql.ResultSet;

/**
 * @author: hyl
 * @date: 2021/03/28
 **/
public class Que190 {

    public int reverseBits(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            //结果先左移一位,把最后一位腾出来放n的最后一位数字
            sum <<= 1;
            //加上n的最后一位数字
            sum = sum | (n&1);
            //n右移
            n >>= 1;

        }
        return sum;

    }
}
