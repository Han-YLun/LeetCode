

/**
 * @author: hyl
 * @date: 2020/12/12
 **/
public class Que461 {

    /**
     * 先换算为二进制然后补位,然后进行异或后,统计为1的位数
     * 时间复杂度O(K),空间复杂度O(K)
     * K为x和y中最长的位数
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {

        if ((x == 0) && (y == 0)){
            return 0;
        }

        String xBinary = toBinary(x);
        String yBinary = toBinary(y);

        if (xBinary.length() != yBinary.length()){
            int n = Math.abs(xBinary.length() - yBinary.length());

            if (xBinary.length() > yBinary.length()){
                for (int i = 0; i < n; i++) {
                    yBinary = "0" + yBinary;
                }
            }else{
                for (int i = 0; i < n; i++) {
                    xBinary = "0" + xBinary;
                }
            }
        }

        char[] arrayX = xBinary.toCharArray();
        char[] arrayY = yBinary.toCharArray();
        for (int i = 0; i < arrayX.length; i++) {
            if (arrayX[i] != arrayY[i]){
                arrayX[i] = '1';
            }else{
                arrayX[i] = '0';
            }
        }

        int res  = 0;
        for (char c : arrayX) {
            if (c == '1'){
                res ++;
            }
        }




        return res;
    }

    /**
     * 先异或,然后取最后一位,然后右移
     * 时间复杂度O(1),空间复杂度O(1)
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance1(int x, int y) {

        int res = 0;

        int z = x ^ y;
        while (z > 0){
            res += (z & 1);
            z >>= 1;
        }

        return res;
    }

    /**
     * 优化方法二,如果有1000001,可以省略中间的0
     * 时间复杂度O(1),空间复杂度O(1)
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {

        int res = 0;

        int z = x ^ y;
        while (z > 0){
            res += 1;
            z &= (z-1);
        }

        return res;
    }

    /**
     * Java内置函数
     * 时间复杂度O(1),空间复杂度O(1)
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance3(int x, int y) {

       return Integer.bitCount(x ^ y);
    }

    /**
     * 获取二进制
     * @param num 数字
     * @return
     */
    public static String toBinary(int num){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(num%2);
            num /= 2;
        }
        return sb.reverse().toString();
    }
}
