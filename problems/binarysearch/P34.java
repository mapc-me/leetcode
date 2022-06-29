package binarysearch;

import java.util.Arrays;

public class P34 {

    public static void main(String[] args) {
//        int[] arr = {5,7,7,8,8,10};
//        int[] arr = {5,8,8,9,9, 10};
//        int[] arr = {5,8,9,9, 10};
//        int[] arr = {5,2,9,9, 10};
        int[] arr = {};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftAnswer = firstLessThan(nums, target);
        if (leftAnswer == nums.length - 1 || nums[leftAnswer + 1] != target) {
            return new int[]{-1, -1};
        }
        int rightAnswer = firstMaxThan(nums, target);



            return new int[]{leftAnswer + 1, rightAnswer - 1};

    }

    private static int firstMaxThan(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int mid;
        while (r > l) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static int firstLessThan(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int mid;
        while (r > l) {
            mid = (r + l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r - 1;
    }
}
