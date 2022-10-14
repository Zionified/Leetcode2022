public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int start = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - start;
            if (prices[i] < start){
                start = prices[i];
            }
            profit = Math.max(profit, Math.max(0, currentProfit));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {   
        int start = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - start;
            if (prices[i] < start){
                start = prices[i];
            }
            profit = profit > currentProfit ? profit : currentProfit;
        }
        return profit;
    }
}
