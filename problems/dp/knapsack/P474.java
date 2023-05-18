package dp.knapsack;

public class P474 {

    public static void main(String[] args) {
        String[] arr = { "10", "0001", "111001", "1", "0" };
        System.out.println(findMaxForm(arr, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] subsets = new int[strs.length][2];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                subsets[i][str.charAt(j) - '0']++;
            }
        }

        for (int[] subset : subsets) {
            for (int i = m; i >= subset[0]; i--) {
                for (int j = n; j >= subset[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - subset[0]][j - subset[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

}
