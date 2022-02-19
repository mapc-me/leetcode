package sorting;

import java.util.Arrays;

public class P238 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] rightPreProduct = new int[nums.length];
        int[] leftPreProduct = new int[nums.length];
        int[] result = new int[nums.length];
        leftPreProduct[0] = 1;
        rightPreProduct[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i ++) {
            leftPreProduct[i] = leftPreProduct[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i --) {
            rightPreProduct[i] = rightPreProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i ++) {
            result[i] = leftPreProduct[i] * rightPreProduct[i];
        }

        return result;
    }
}
