package dp.unboundedknapsack;

import java.util.Arrays;

public class P377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return topDown(nums, target, 0, dp);
    }

    public int topDown(int[] nums, int target, int sum, int[] dp) {

        if (dp[sum] != -1) {
            return dp[sum];
        }
        if (sum == target) {
            return 1;
        }


        int count = 0;
        for (int num : nums) {
            if (sum + num <= target) {
                count += topDown(nums, target, sum + num, dp);
            }
        }
        dp[sum] = count;
        return count;
    }

    public int bottomUp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i ++) {
            for (int num : nums) {
                if (num > i) {
                    continue;
                }
                dp[i] += dp[i - num];
            }
        }



        return dp[target];
    }

}
