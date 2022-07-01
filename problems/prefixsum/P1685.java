package prefixsum;

public class P1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        int left = 0;
        int tmp;
        for (int i = 0; i < nums.length; i ++) {
            sum -= nums[i];
            tmp = nums[i];
            nums[i] = (i * nums[i] - left) + (sum - (nums.length - i - 1) * nums[i]);
            left += tmp;
        }

        return nums;

    }
}
