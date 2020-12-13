/**
 * @author: hyl
 * @date: 2020/12/13
 **/
public class Que5625 {

    /**
     * 通过题目的含义计算
     * 时间复杂度为O(1),空间复杂度为O(1)
     *
     * @param n
     * @return
     */
    public int numberOfMatches(int n) {
        if (n <= 0) {
            return 0;
        }

        int res = 0;
        while (n > 1) {

            if ((n & 1) == 1) {
                res += ((n - 1) / 2);
                n = (n - 1) / 2 + 1;
            } else {
                res += (n / 2);
                n /= 2;
            }
        }
        return res;

    }

    /**
     * 共有n个队伍，一个冠军，需要淘汰n-1个 队伍。
     * 每一场比赛淘汰一个队伍，因此进行了n-1场比赛。
     * 所以共有n-1个配对
     * 时间复杂度为O(1),空间复杂度为O(1)
     *
     * @param n 队伍数
     * @return
     */
    public int numberOfMatches1(int n) {
        return n - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Que5625().numberOfMatches(14));
    }
}
