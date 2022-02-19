package sorting.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56 {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}};
//        int[][] intervals = {{1, 3}, {2, 2}};
        int[][] intervals = {{1, 3}};

        for (int[] interval : merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            }
            if (o1[0] > o2[0]) {
                return 1;
            }
            return -1 * Integer.compare(o2[1], o1[1]);
        });

        int[] candidate = new int[2];
        candidate[0] = -1;
        candidate[1] = -1;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (candidate[0] == -1 && candidate[1] == -1) {
                candidate[0] = intervals[i][0];
                candidate[1] = intervals[i][1];
            }

            if (intervals[i + 1][0] <= candidate[1]) {
                candidate[1] = Math.max(Math.max(candidate[1], intervals[i][1]), intervals[i + 1][1]);
            } else {
                result.add(candidate);
                candidate = new int[2];
                candidate[0] = -1;
                candidate[1] = -1;
            }
        }

        if (candidate[0] != -1 && candidate[1] != -1) {
            result.add(candidate);
        }
        if (candidate[0] == -1 && candidate[1] == -1) {
            candidate[0] = intervals[intervals.length - 1][0];
            candidate[1] = intervals[intervals.length - 1][1];
            result.add(candidate);
        }

        int[][] intResult = new int[result.size()][2];
        int i = 0;
        for (int[] commonIntervals : result) {
            intResult[i] = commonIntervals;
            i++;
        }
        return intResult;
    }
}
