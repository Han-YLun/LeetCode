/**
 * @author: hyl
 * @date: 2019/08/06
 **/
public class Que69 {

    //二分法求解
    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x, result = 0;
        while (left <= right) {
            int middle = (left + right) / 2;


            if (middle == (x / middle)) {
                return middle;
            } else if (middle > (x / middle)) {
                right = middle - 1;
            } else if (middle < (x / middle)) {
                left = middle + 1;
                result = middle;
            }
        }

        return result;

    }

    public int mySqrt1(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x, result = 0;
        while (left <= right) {
            int middle = left + (right-left) / 2;


            if ((long) middle * middle <= x) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Que69().mySqrt1(2147483647));
    }


}
