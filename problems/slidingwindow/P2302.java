package slidingwindow;

/**
 * Solve again
 */
public class P2302 {

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        int k = 10000;

        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {

        long sum = 0;
        long ans = 0;

        int r = 0;

        for (int i = 0; i < nums.length; i ++) {
            while (r < nums.length && ((sum + nums[r]) * (r - i + 1)) < k) { //check condition for first index
                sum += nums[r];
                r ++;
            }


            ans += r - i;

            sum -= nums[i];
        }

        return ans;

    }
}
