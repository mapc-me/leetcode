package dynamicprogramming;

public class P1014 {
    public int maxScoreSightseeingPair(int[] values) {
        final int n = values.length;

        int max = values[0];
        int maxDiff = 0;

        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }

        return maxDiff;
    }
}
