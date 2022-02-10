package slidingwindow;

public class P713 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 1;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int currentProduct = nums[0];
        int satisfyingSubarrays = 0;

        if (k == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length && left < nums.length; ) {
            if (currentProduct >= k && left <= i) {
                currentProduct /= nums[left];
                left ++;
                continue;
            }
            if (currentProduct < k || k == 1) {
                if (currentProduct < k) {
                    satisfyingSubarrays += i - left + 1;
                }
                i ++;
                if (i < nums.length) {
                    currentProduct *= nums[i];
                }
            }
        }

        return satisfyingSubarrays;
    }
}

/**
 * [1 2] subarrays = 2 {1}, {2}  -> (N + (N+1)) / 2
 * [1 2 3] subarrays = 7 {1 2}, {2 3} {1} {2} {3} {1, 2, 3}
 */


/**
 * [2] - 1
 * [2, 10] - 3
 * [2, 10, 3] - 3 + 3 = 6
 * [2, 10, 3, 5] - 6 + 4 = 10
 * each time increase to (left - i) + 1
 */
