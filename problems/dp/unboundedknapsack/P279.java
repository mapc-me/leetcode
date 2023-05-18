package dp.unboundedknapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P279 {
    public int numSquares(int n) {
        List<Integer> perfectSquareList = new ArrayList<>();
        int lastPerfectSquare = (int) Math.sqrt(n);

        for (int i = 1; i <= lastPerfectSquare; i++) {
            perfectSquareList.add(i * i);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (Integer perfectSquare : perfectSquareList) {
            for (int i = perfectSquare; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - perfectSquare] + 1);
            }
        }

        return dp[n];
    }
}
