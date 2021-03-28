import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/03/27
 **/
public class Que412 {

    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        if (n < 1) {
            return resList;
        }

        for (int i = 1; i <= n; i++) {

            int modThree = i % 3;
            int modFive = i % 5;
            if ((modThree == 0) && (modFive == 0)) {
                resList.add("FizzBuzz");
            } else if (modThree == 0) {
                resList.add("Fizz");
            } else if (modFive == 0) {
                resList.add("Buzz");
            } else {
                resList.add(i + "");
            }
        }
        return resList;
    }
}
