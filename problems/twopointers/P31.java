package twopointers;

import java.util.Arrays;

public class P31 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 1, 5};
        int[] nums = {2, 1, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] > nums[i]) {
                    minIndex = i;
                    maxIndex = j;
                }
            }
        }

        if (minIndex != -1) {
            int temp = nums[minIndex];
            nums[minIndex] = nums[maxIndex];
            nums[maxIndex] = temp;
        }

        Arrays.sort(nums, minIndex + 1, nums.length);
    }
}
