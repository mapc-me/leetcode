package binarysearch;

public class P153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;

        while (l < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            mid = (r + l) / 2;


            if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
