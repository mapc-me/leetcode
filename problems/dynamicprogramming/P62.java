package dynamicprogramming;

public class P62 {

    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[n][m];

            dp[0][0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int left = 0;
                    int up = 0;

                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    dp[i][j] += left + up;
                }
            }

            return dp[n - 1][m - 1];
        }
    }

    static class RecursionSolution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[n][m];
            dp[0][0] = 1;
            uniquePaths(m - 1, n - 1, dp);
            return dp[n - 1][m - 1];

        }

        public void uniquePaths(int m, int n, int[][] dp) {
            if (n < 0 || m < 0) {
                return;
            }
            if (n == 0 && m == 0) {
                return;
            }
            if (dp[n][m] != 0) {
                return;
            }

            uniquePaths(m - 1, n, dp);
            uniquePaths(m, n - 1, dp);

            if (n > 0) {
                dp[n][m] += dp[n - 1][m];
            }
            if (m > 0) {
                dp[n][m] += dp[n][m - 1];
            }
        }
    }
}
