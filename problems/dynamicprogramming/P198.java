package dynamicprogramming;

public class P198 {
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return nums[0];
        }


        int[] sum = new int[n];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i ++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
        }

        return Math.max(sum[n - 1], sum[n - 2]);
    }
}
