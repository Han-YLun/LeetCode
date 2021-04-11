/**
 * @Author: Han-YLun
 * @date 2019/5/12 0012
 * @Version 1.0
 */
public class Que7 {

    /**
     * 使用long存储int,然后反转后,判断是否超出范围
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            result = result * 10 + temp;
        }

        if (result > Math.pow(2, 31) - 1 || result < -Math.pow(2, 31)) {
            return 0;
        }

        return (int) result;
    }

    /**
     * 使用String
     * @param x
     * @return
     */
    public int reverse1(int x) {
        StringBuilder xReverseStr = new StringBuilder();
        String xStr = String.valueOf(x);
        boolean isNegative = xStr.contains("-");

        if (isNegative){
            xStr = xStr.replace("-","");
        }


        for (int i = xStr.length() - 1; i >= 0; i--) {
            xReverseStr.append(xStr.charAt(i));
        }

        long result = Long.parseLong(xReverseStr.toString());
        if (isNegative) {
            result = -result;
        }

        if (result > Math.pow(2, 31) - 1 || result < -Math.pow(2, 31)) {
            return 0;
        }

        return (int) result;
    }

    /**
     * 在每次取余的时候就判断
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;

            if (result > (Integer.MAX_VALUE / 10)){
                return 0;
            }

            if (result < (Integer.MIN_VALUE / 10)){
                return 0;
            }

            result = result * 10 + temp;
        }


        return result;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Que7().reverse(-2147483648));
        System.out.println(new Que7().reverse1(-2147483648));
    }
}
