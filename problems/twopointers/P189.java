package twopointers;

public class P189 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
    }
    public static void rotate(int[] nums, int k) {
        int temp = nums[0];
        int secondTemp = nums[0];
        int n = nums.length;
        k = k % n;
        for (int i = 1; i < n + k; i ++) {
            secondTemp = nums[i % n];
            nums[i % n] = temp;
            temp = secondTemp;
        }
    }
}
