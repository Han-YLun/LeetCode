import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2021/04/12
 **/
public class Que204 {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            boolean prime = isPrime(n);
            if (prime) {
                sum++;
            }
        }
        return sum;

    }

    private boolean isPrime(int n) {


        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes1(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(new Que204().countPrimes2(499979));
    }
}
