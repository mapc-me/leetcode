package grind75.week1;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = -1;
        int r = n;

        while (l < r - 1) {
            int mid = (l + r) / 2;

            boolean fromDiffParts = (nums[mid] >= nums[0] && target < nums[0]) || (nums[mid] < nums[0] && target >= nums[0]);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                if (fromDiffParts) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else {

                if (fromDiffParts) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        if (l < n && l != -1 && nums[l] == target) {
            return l;
        }
        if (r >= 0 && r != n && nums[r] == target) {
            return r;
        }
        return -1;
    }
}
