package grind75.week1;

public class Leetcode53 {

    /**
     * Sliding Windows approach (non-effective)
     */
    public int maxSubArraySlidingWindows(int[] nums) {
        int answer = nums[0];

        int currentSum = 0;

        int l = 0;
        int r = 0;
        int n = nums.length;
        while (l < n) {
            while (r < n && (nums[l] > 0 && currentSum > 0|| r == l)) {
                currentSum += nums[r];
                r ++;
                // System.out.println(currentSum + " " + l + " " + r);
                answer = Math.max(answer, currentSum);
                if (currentSum < 0) {
                    break;
                }
            }
            // System.out.println(currentSum + " " + l + " " + r);
            answer = Math.max(answer, currentSum);
            currentSum -= nums[l];
            l ++;
        }

        return answer;
    }

    /**
     * Dp approach (beats 100%)
     */
    public int maxSubArrayDpApproach(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i ++) {
            prev = Math.max(prev + nums[i], nums[i]);
            ans = Math.max(ans, prev);
        }

        return ans;
    }

}
