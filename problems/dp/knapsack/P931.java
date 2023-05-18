package dp.knapsack;

public class P931 {

    public int minFallingPathSum(int[][] matrix) {
        final int N = matrix.length;

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i ++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                    continue;
                }
                if (j == N - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], Math.min(dp[i - 1][j + 1] + matrix[i][j], dp[i - 1][j - 1] + matrix[i][j]));
            }
        }

        int ans = dp[N - 1][0];
        for (int i = 1; i < N; i ++) {
            ans = Math.min(ans, dp[N - 1][i]);
        }

        return ans;
    }
}
