package dynamicprogramming;

public class P746 {

    public int minCostClimbingStairs(int[] cost) {
        final int N = cost.length;
        int[] ans = new int[2];

        ans[0] = cost[0];
        ans[1] = cost[1];

        for (int i = 2; i < N; i ++) {
            int current = Math.min(ans[0] + cost[i], ans[1] + cost[i]);
            ans[0] = ans[1];
            ans[1] = current;
        }

        return Math.min(ans[0], ans[1]);

    }
}
