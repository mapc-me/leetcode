package dynamicprogramming;

public class P1277 {

    public static void main(String[] args) {
//        int[][] arr = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
//        int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 0 } };
        int[][] arr = { { 1, 1, 1, 1 } };

        System.out.println(countSquares(arr));
    }

    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                answer++;
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                answer++;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                answer += dp[i][j];
            }

        }

        return answer;
    }
}

