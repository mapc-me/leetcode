package grind75.week1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        if (n == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> newIntervals = new ArrayList<>();
        int i = 0;

        while (i < n) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                newIntervals.add(interval);
                if (i == n - 1 || intervals[i + 1][0] > newInterval[1]) {
                    newIntervals.add(newInterval);
                }
                i ++;
                continue;
            }
            if (interval[0] > newInterval[1]) {
                if (i == 0) {
                    newIntervals.add(newInterval);
                }
                newIntervals.add(interval);
                i++;
                continue;
            }

            int x = newInterval[0];
            int y = newInterval[1];

            while (i < n && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
                x = Math.min(x, intervals[i][0]);
                y = Math.max(y, intervals[i][1]);
                i ++;
            }

            newIntervals.add(new int[]{x, y});
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
