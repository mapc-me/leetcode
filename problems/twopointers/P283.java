package twopointers;

import java.util.Arrays;

public class P283 {

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0};
//        int[] nums = {0, 1};
//        int[] nums = {0, 1, 0, 0, 0, 1, 0, 1};
        int[] nums = {1, 0, 0, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int r = 0, l = 0;
        int tmp;

        while (l < nums.length - 1 && r < nums.length - 1) {
            if (nums[l] != 0) {
                l++;
                continue;
            }

            r = Math.max(l, r);
            while (r < nums.length - 1 && nums[r] == 0) {
                r ++;
            }

            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
