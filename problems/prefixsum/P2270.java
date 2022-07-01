package prefixsum;

public class P2270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        long prefixSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            prefixSum += nums[i];
            if (prefixSum >= (sum - prefixSum)) {
                ans ++;
            }
        }

        return ans;

    }
}
