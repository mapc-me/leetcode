package decemberchallange;

public class P121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i ++) {
            profit = Math.max(prices[i] - min, profit);
            min = Math.min(prices[i], min);
        }

        return profit;

    }
}
