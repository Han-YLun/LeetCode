/**
 * @Author: Han-YLun
 * @date 2019/6/2 0002
 * @Version 1.0
 */
public class Que70 {

    /**
     * 使用迭代计算,使用递归会TimeOut
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int prev = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            int temp = cur;
            cur += prev;
            prev = temp;

        }
        return cur;
    }

    public static void main(String[] args) {
        Que70 que70 = new Que70();
        int i = que70.climbStairs(3);
        System.out.println(i);

    }
}
