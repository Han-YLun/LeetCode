import java.util.HashSet;

/**
 * @author: hyl
 * @date: 2021/03/28
 **/
public class Que202 {
    public boolean isHappy(int n) {

        if (n == 0) {
            return true;
        }

        int index = 0;
        while (index++ < 10) {
            n = getNum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isHappy1(int n) {

        if (n == 0) {
            return true;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        while ((n != 1) && !hashSet.contains(n)){
            hashSet.add(n);
            n = getNum(n);
        }

        return n==1;
    }


    private int getNum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Que202().isHappy(19));
    }
}
