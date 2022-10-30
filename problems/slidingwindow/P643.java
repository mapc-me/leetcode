package slidingwindow;

public class P643 {

    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];

                if (i == k - 1) {
                    max = sum;
                }

                continue;
            }

            sum += nums[i];
            sum -= nums[i - k];

            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}
