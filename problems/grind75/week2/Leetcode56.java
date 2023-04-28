package grind75.week2;

import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            }
            if (a[0] < b[0]) {
                return -1;
            }
            return Integer.compare(a[1], b[1]);
        });

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        int n = intervals.length;

        for (int i = 1; i < n; i ++) {
            int[] last = result.getLast();
            int[] interval = intervals[i];

            if (last[1] >= interval[0]) {
                if (last[1] < interval[1]) {
                    last[1] = interval[1];
                }
            } else {
                result.add(interval);
            }
        }

        int[][] answer = new int[result.size()][2];

        int i = 0;
        for (int[] interval : result) {
            answer[i++] = interval;
        }

        return answer;
    }
}
