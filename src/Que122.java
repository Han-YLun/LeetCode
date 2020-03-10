/**
 * @author: hyl
 * @date: 2019/08/04
 **/
public class Que122 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0){
            return 0;
        }

        int profit = 0;

        for (int i = 0; i < prices.length-1 ; i++) {

            if (prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}
