package dynamicprogramming;

public class P53 {

    public int cadanesAlgorithm(int[] nums) {
        int n = nums.length;

        int maximum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            maximum += num;
            ans = Math.max(ans, maximum);

            if (maximum < 0) {
                maximum = 0;
            }
        }

        return ans;
    }

    public int simpleDpSolution(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
