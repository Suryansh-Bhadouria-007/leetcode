package seanp;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            } else if (prices[i] - minSoFar > result) {
                result = prices[i] - minSoFar;
            }
        }
        return result;
    }
}
