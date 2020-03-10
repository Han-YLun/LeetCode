import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyl
 * @date: 2019/08/04
 **/
public class Que121 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2){
            return 0;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }    
        }

        return maxProfit;

    }

    public int maxProfit1(int[] prices) {


        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (minPrice > prices[i]){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }


        return maxProfit;

    }
}
