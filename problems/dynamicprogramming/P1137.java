package dynamicprogramming;

public class P1137 {
    public int tribonacci(int n) {
        int[] tri = new int[3];
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;

        for (int i = 3; i <= n; i ++) {
            int current = tri[0] + tri[1] + tri[2];
            tri[0] = tri[1];
            tri[1] = tri[2];
            tri[2] = current;
        }

        return tri[Math.min(n, 2)];

    }
}
