package lessons;

public class P152 {

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        Integer max = null;
        int currentMax = 1;
        for (int num : nums) {
            if (num == 0) {
                currentMax = 1;
                if (max == null || max < 0) {
                    max = 0;
                }
                continue;
            }
            currentMax *= num;
            max = max == null ? currentMax : Math.max(max, currentMax);
        }

        currentMax = 1;

        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] == 0) {
                currentMax = 1;
                if (max < 0) {
                    max = 0;
                }
                continue;
            }
            currentMax *= nums[i];
            max = Math.max(max, currentMax);
        }

        return currentMax;

    }
}
