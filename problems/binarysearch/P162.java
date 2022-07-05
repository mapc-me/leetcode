package binarysearch;

public class P162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length;
        int mid;

        while (r >= l) {
            mid = (r + l) / 2;

            boolean moreThanLeft = mid == 0 || nums[mid] > nums[mid - 1];
            boolean moreThanRight = mid == nums.length - 1 || nums[mid] > nums[mid + 1];


            if (moreThanLeft && moreThanRight) {
                return mid;
            }

            if (!moreThanLeft) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;

    }
}
