import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author: hyl
 * @date: 2021/05/09
 **/
public class Que371 {
    public int getSum(int a, int b) {
        if(a == 0){
            return b;
        }

        if(b == 0){
            return a;
        }

        //低位和进位
        int lower , carrier;
        while (true){
            //计算低位用异或
            lower = a^b;
            //计算高位用与
            carrier = a &b;
            if (carrier == 0){
                break;
            }

            a = lower;
            b = carrier<<1;
        }

        return lower;
    }

    public static void main(String[] args) {
        System.out.println(new Que371().getSum(-1,2));
    }
}
