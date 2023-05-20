package dp.fibonacci;

public class P983 {
    final int N = 365;

    public int mincostTickets(int[] days, int[] costs) {
        final int n = days.length;
        int[] dp = new int[days[n - 1] + 1];

        dp[days[0]] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        int index = 1;
        for (int i = days[0]; i <= days[n - 1]; i ++) {
            while (index < n && i < days[index]) {
                dp[i] = dp[days[index - 1]];
                i ++;
            }
            int candidate1 = dp[i - 1] + costs[0];
            int candidate7 = costs[1];
            int candidate30 = costs[2];

            if (i >= 7) {
                candidate7 = dp[i - 7] + costs[1];
            }
            if (i >= 30) {
                candidate30 = dp[i - 30] + costs[2];
            }

            dp[i] = Math.min(candidate1, Math.min(candidate7, candidate30));
            index++;
        }

        return dp[days[n - 1]];

    }
}
