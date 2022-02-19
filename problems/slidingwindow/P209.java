package slidingwindow;

/**
 * 209. Minimum Size Subarray Sum
 */
public class P209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int length = 0;
        int sum = 0;
        int answer = -1;
        for (int i = 0; i < nums.length; ) {
            if (sum < target) {
                sum += nums[i];
                i++;
                length++;
            }

            if (target == sum && (answer == -1 || length < answer)) {
                answer = length;
            }
            if (sum >= target) {
                sum -= nums[i - length + 1];
                length -= 1;
            }
        }
        if (answer > -1) {
            return answer;
        } else {
            return 0;
        }
    }
}
