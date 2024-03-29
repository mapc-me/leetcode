package dp.knapsack;

import java.util.Arrays;

public class P322 {

    public static void main(String[] args) {
        int[] arr = {5,3};
        int amount = 11;
        System.out.println(coinChange(arr, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0]  = 0;


        for (int i = 1; i <= amount; i ++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }


        return dp[amount] > amount ? -1 : dp[amount];
    }
}
