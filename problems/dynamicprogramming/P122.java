package dynamicprogramming;

public class P122 {
    public int maxProfit(int[] prices) {
        final int n = prices.length;

        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                answer += Math.max(0, prices[i] - prices[i - 1]);
            }
        }

        return answer;
    }
}
