package dp.knapsack;

import java.util.List;

public class P2218 {

    public static void main(String[] args) {
        System.out.println(maxValueOfCoins(List.of(
            List.of(9, 8, 1),
            List.of(7, 8, 5),
            List.of(100, 1, 3)
        ), 3));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();

        int[] dp = new int[k + 1];

        for (List<Integer> pile : piles) {
            for (int j = k; j >= k; j++) {
                int sum = 0;
                int min = Math.min(j, pile.size());
                for (int coin = 0; coin < min; coin++) {
                    sum += pile.get(coin);
                    dp[j] = Math.max(dp[j], sum + dp[j - coin - 1]);
                }
            }
        }

        return dp[k];

    }
}
