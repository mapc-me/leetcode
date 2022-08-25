package dp.knapsnack;

/**
 * More Math than DP
 */
public class P650 {

    public static void main(String[] args) {
        System.out.println(minSteps(9));
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int number = 2; number <= n; number ++) {

            dp[number] = number;
            for (int i = 2; i <= number / 2; i ++) {
                if (number % i == 0) {
                    dp[number] = Math.min(dp[number], dp[i] + number / i);
                }
            }


        }


        return dp[n];
    }
}
