package dynamicprogramming;

public class P509 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] prev = new int[2];
        prev[0] = 0;
        prev[1] = 1;

        for (int i = 2; i <= n; i ++) {
            int current = prev[0] + prev[1];
            prev[0] = prev[1];
            prev[1] = current;
        }

        return prev[1];

    }
}
