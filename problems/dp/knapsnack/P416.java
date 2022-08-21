package dp.knapsnack;

public class P416 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        int[] arr = {1,5,11,11};
//        int[] arr = {1,5,11,7};
        int[] arr = {1,2,3,5};
//        System.out.println(canPartitionBottomUp(arr));
        System.out.println(canPartitionTopDown(arr));
    }


    public static boolean canPartitionBottomUp(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;

        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i ++) {
            dp[i][0] = true;
        }

        if (sum >= nums[0]) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i ++) {
            for (int j = 1; j <= sum; j ++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }


    public static boolean canPartitionTopDown(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;

        return recursiveTopDown(new Boolean[nums.length][sum + 1], nums, 0, sum);
    }

    public static boolean recursiveTopDown(Boolean[][] dp, int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }
        boolean attempt1 = false;

        if (sum >=0 && dp[index][sum] != null) {
            return dp[index][sum];
        }
        if (nums[index] <= sum) {
            attempt1 = recursiveTopDown(dp, nums, index + 1, sum - nums[index]);
        }
        boolean attempt2 = recursiveTopDown(dp, nums, index + 1, sum);
        dp[index][sum] = attempt2 | attempt1;
        return dp[index][sum];
    }
}
