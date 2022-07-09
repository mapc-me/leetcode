package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P300 {

    public static void main(String[] args) {
        int[] arr = {7, 1};

        System.out.println(lengthOfLIS(arr));

    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < nums.length; i ++) {
            int lastPosition = binarySearch(dp, nums[i]);
            dp[lastPosition] = nums[i];
        }

        int max = 0;
        for (int i = 0; i < dp.length; i ++) {
            if (dp[i] != Integer.MAX_VALUE) {
                max = i;
            }
        }

        return max + 1;
    }

    public static int binarySearch(int[] dp, int target) {
        int l = 0;
        int r = dp.length;
        while (r > l) {
            int mid = (l + r) / 2;
            if (dp[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
