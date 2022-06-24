package twopointers;

import java.util.Arrays;

public class P16 {

    public static void main(String[] args) {

        int[] arr = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[3];
        int current;
        int start, end;

        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;

            while (start < end) {
                current = nums[i] + nums[start] + nums[end];
                if (current < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(result - target) > Math.abs(current - target)) {
                    result = current;
                }
            }
        }
        return result;
    }

}
