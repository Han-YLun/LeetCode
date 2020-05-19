import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2020/05/19
 **/
public class Que1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        //最多的糖果
        int mostCandyNumber = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] >= mostCandyNumber){
                mostCandyNumber = candies[i];
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add((candy + extraCandies) >= mostCandyNumber);
        }
        return result;
        
    }
}
