package dp.fibonacci;

public class P91 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < n; i++) {
            int a = s.charAt(i - 1) - '0';
            int b = s.charAt(i) - '0';

            if (a != 0 && a * 10 + b <= 26) {
                dp[i + 1] += dp[i - 1];
            }
            if (b != 0) {
                dp[i + 1] += dp[i];
            }
        }

        return dp[n];
    }

}
