/**
 * @Author: Han-YLun
 * @date 2019/5/12 0012
 * @Version 1.0
 */
public class Que50 {

    public double myPow(double x, int n) {

 /*       if (n == 0 && x !=0){
            return 1;
        }

        boolean isPositive = n > 0 ? true : false;


        if (!isPositive){
            n = -n;
        }*/

        double res = 1.0;

        for (int i = n; i !=0; i/=2) {

            if (i%2 != 0){
                res *= x;
            }
             x *= x;
        }

        return n < 0 == true ? 1/res : res;
    }
}
