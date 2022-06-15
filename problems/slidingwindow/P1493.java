package slidingwindow;

public class P1493 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(arr));
    }

    public static int longestSubarray(int[] nums) {
        int r = 0;
        boolean used = false;
        int ans = 0;
        for (int l = 0; l < nums.length; l++) {
            while (r < nums.length) {
                if (nums[r] == 0 && used) {
                    break;
                }
                if (nums[r] == 0) {
                    used = true;
                }
                r++;
            }

            if (used || r - l == nums.length) {
                ans = Math.max(ans, r - l - 1);
            } else {
                ans = Math.max(ans, r - l);
            }

            if (nums[l] == 0) {
                used = false;
            }
        }
        return ans;
    }
}
