package dp.knapsack;

public class P494 {

    public static void main(String[] args) {
//        int[] arr = { 1, 1, 1, 1, 1 };
//        int[] arr = { 1 };
//        int[] arr = { 0,0,0,0,0,0,0,0,1 };
        int[] arr = { 100 };
        System.out.println(findTargetSumWays(arr, -200));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int max = 0;
        for (int num : nums) {
            max += num;
        }
        max = Math.max(max, Math.abs(target));

        int[][] dp = new int[nums.length][max + 1];

        dp[0][Math.abs(nums[0])] = 1;

        if (nums[0] == 0) {
            dp[0][Math.abs(nums[0])] = 2;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int sum = 0; sum <= max; sum++) {
                if (Math.abs(sum + nums[i]) <= max) {
                    dp[i][sum] += dp[i - 1][Math.abs(sum + nums[i])];
                }
                if (Math.abs(sum - nums[i]) <= max) {
                    dp[i][sum] += dp[i - 1][Math.abs(sum - nums[i])];
                }
            }
        }

        return dp[nums.length - 1][Math.abs(target)];
    }
}
