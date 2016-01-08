/**
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
 public class Solution {
    public int maxProfit(int[] prices) {

        // corner case
        if ((prices == null) || (prices.length <= 1)) {
            return 0;
        }

        int maxProfit = 0;
        int currentProfit = 0;break;
        int lowerPrice = prices[0]; // set the original lower price as the first-day price

        for (int i = 1; i < prices.length; i++) {
            currentProfit = prices[i] - lowerPrice;
            // (price[i] >=lowerPrice) && (price[i] - lowerPrice) > max) => update max and keep going
            // (price[i] >= lowerPrice) && (price[i] - lowerPrice) <= max => keep going
            // (price[i] < lowerPrice) => update lowerPrice
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            } else if (prices[i] < lowerPrice) {
                lowerPrice = prices[i];
            }
        }

        return maxProfit;

    }
}
