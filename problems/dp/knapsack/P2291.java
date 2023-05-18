package dp.knapsack;

import java.util.Arrays;

public class P2291 {
    public static void main(String[] args) {
        maximumProfit(new int[] { 5, 4, 6, 2, 3 }, new int[] { 8, 5, 100, 3, 5 }, 10);
    }

    public static int maximumProfit(int[] present, int[] future, int budget) {
        int[][] dp = new int[present.length][budget + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int ans = topDown(present, future, budget,  0, dp);
        System.out.println(ans);
        return ans;
    }

    public static int topDown(int[] present, int[] future, int budget, int i, int[][] dp) {
        if (i >= present.length) {
            return 0;
        }

        if (dp[i][budget] != -1) {
            return dp[i][budget];
        }

        int profitIfNotBuy = topDown(present, future, budget, i + 1, dp);
        int profitIfBuy = 0;
        if (budget >= present[i]) {
            profitIfBuy = future[i] - present[i] + topDown(present, future, budget - present[i], i + 1, dp);
        }
        dp[i][budget] = Math.max(profitIfBuy, profitIfNotBuy);

        return dp[i][budget];
    }
}
