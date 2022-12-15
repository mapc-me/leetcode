package dynamicprogramming;

public class P1641 {
    public int countVowelStrings(int n) {
        int[] dp = { 1, 1, 1, 1, 1 };

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < dp.length; j++) {
                int cur = 0;
                for (int k = j; k < dp.length; k++) {
                    cur += dp[k];
                }
                dp[j] = cur;
            }
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans += dp[i];
        }

        return ans;
    }
}
