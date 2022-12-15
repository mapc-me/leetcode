package dynamicprogramming;

public class P70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] prev = new int[2];

        prev[0] = 1;
        prev[1] = 2;

        for (int i = 2; i < n ; i ++) {
            int current = prev[0] + prev[1];
            prev[0] = prev[1];
            prev[1] = current;
        }


        return prev[1];

    }
}
