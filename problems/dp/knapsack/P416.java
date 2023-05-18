package dp.knapsack;

public class P416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        int n = nums.length;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return topDown(nums, target, 0, 0, dp);
    }

    public boolean topDown(int[] nums, int target, int current, int i, Boolean[][] dp) {
        if (current == target) {
            return true;
        }
        if (i >= nums.length || current > target) {
            return false;
        }

        if (dp[i][current] != null) {
            return dp[i][current];
        }

        boolean ifNotTake = topDown(nums, target, current, i + 1, dp);
        boolean ifTake = topDown(nums, target, current + nums[i], i + 1, dp);

        dp[i][current] = ifNotTake | ifTake;

        return dp[i][current];
    }

    public boolean bottomUp(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }
}
