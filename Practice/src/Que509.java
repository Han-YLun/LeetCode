/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que509 {

    public int fib(int N) {

        if(N == 0 || N == 1)
            return N;
        return fib(N-1) + fib(N-2);
    }
}
