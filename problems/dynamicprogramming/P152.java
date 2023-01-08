package dynamicprogramming;

public class P152 {

    public static void main(String[] args) {
//        int[] arr = {2,3,-2,4};
//        int[] arr = {-2, 0, -1};
        int[] arr = { 2, -5, -2, -4, 3 };

        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int maximum = 1;
        int minimum = 1;

        int ans = nums[0];

        for (int num : nums) {
            int tmp = Math.max(1, Math.max(minimum, maximum)) * num;
            minimum = Math.min(1, Math.min(minimum, maximum)) * num;
            maximum = tmp;

            ans = Math.max(ans, Math.max(minimum, maximum));
        }

        return ans;

    }
}
