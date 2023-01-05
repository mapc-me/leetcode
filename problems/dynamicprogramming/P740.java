package dynamicprogramming;

public class P740 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 0; i < max + 1; i++) {
            freq[i] *= i;
        }

        int[] dp = new int[max + 1];
        dp[1] = freq[1];
        int answer = dp[1];

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i]);
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }
}
