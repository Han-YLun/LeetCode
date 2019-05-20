import java.util.*;

/**
 * @Author: Han-YLun
 * @date 2019/5/12 0012
 * @Version 1.0
 */
public class Que7 {

    public int reverse(int x) {
        long result = 0;
        while (x != 0){
            int temp = x%10;
            x /= 10;
            result = result *10 + temp;
        }

        if (result > Math.pow(2,31)-1 || result< -Math.pow(2,31)){
            return 0;
        }

        return (int)result;
    }
}
