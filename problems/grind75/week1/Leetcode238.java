package grind75.week1;

public class Leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] rightPrefixMult = new int[n];
        int[] leftPrefixMult = new int[n];

        rightPrefixMult[n - 1] = 1;
        leftPrefixMult[0] = 1;

        for (int i = 1; i < n; i ++) {
            leftPrefixMult[i] = leftPrefixMult[i - 1] * nums[i - 1];
            rightPrefixMult[n - i - 1] =  rightPrefixMult[n - i] * nums[n - i];
        }

        int[] answer = new int[n];
        answer[0] = rightPrefixMult[0];
        answer[n - 1] = leftPrefixMult[n - 1];

        for (int i = 1; i < n - 1; i ++) {
            answer[i] = rightPrefixMult[i] * leftPrefixMult[i];
        }

        return answer;

    }
}
