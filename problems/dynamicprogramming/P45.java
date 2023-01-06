package dynamicprogramming;

public class P45 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};

        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        final int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i ++) {
            dp[i] = n;
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (nums[j] >= (i - j) ) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }

            }

        }

        return dp[n - 1];
    }
}
