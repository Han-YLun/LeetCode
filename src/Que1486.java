/**
 * @author: hyl
 * @date: 2020/09/17
 **/
public class Que1486 {

    /**
     * 暴力即可
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {

        int res = start;
        int temp = start;
        n--;
        while (n-- > 0) {
            temp = temp + 2;
            res = res ^ temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Que1486().xorOperation(4, 3));
        //System.out.println(3 ^ 5 ^ 7 ^ 9);
    }

}
