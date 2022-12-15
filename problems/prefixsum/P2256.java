package prefixsum;

public class P2256 {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i ++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long ans = prefixSum[n - 1] / n;
        int index = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            long left = prefixSum[i] / (i + 1);
            long right = (prefixSum[n - 1] - prefixSum[i]) / (n - i - 1);

            if (Math.abs(left - right) <= ans) {
                ans = Math.abs(left - right);
                index = i;
            }

        }


        return index;
    }
}
