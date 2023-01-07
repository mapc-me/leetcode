package dynamicprogramming;

public class P918 {

    public static void main(String[] args) {
//        int[] arr = {2,-2,2,7,8,0};
//        int[] arr = { -2, 4, -5, 4, -5, 9, 4 };
        int[] arr = { 5, -3, 5 };
        maxSubarraySumCircular(arr);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] prefixSumFromRight = new int[n];
        prefixSumFromRight[n - 1] = nums[n - 1];

        int prefixSum = nums[n - 1];
        for (int i = n - 2; i >= 0; i --) {
            prefixSum += nums[i];
            prefixSumFromRight[i] = Math.max(prefixSumFromRight[i + 1], prefixSum);
        }

        int circleAnswer = prefixSumFromRight[0];
        int current = 0;
        int kadanesAns = Integer.MIN_VALUE;
        prefixSum = 0;
        for (int i = 0; i < n; i ++) {

            //kadane's part
            current += nums[i];
            if (current > kadanesAns) {
                kadanesAns = current;
            }
            if (current < 0) {
                current = 0;
            }

            prefixSum += nums[i];
            if (i < n - 1) {
                circleAnswer = Math.max(circleAnswer, prefixSumFromRight[i + 1] + prefixSum);
            }
        }

        return Math.max(kadanesAns, circleAnswer);

    }
}
