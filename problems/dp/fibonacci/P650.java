package dp.fibonacci;

public class P650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j - 1) + 1);
                }
            }
        }

        return dp[n];
    }
}
