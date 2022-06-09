package sorting.mergeintervals;

import java.util.*;

public class P57 {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

//        int[][] arr = {{1, 2}, {5, 6}};
//        int[] newInterval = {3, 4};

//        int[][] arr = {{1, 2}, {4, 5}};
//        int[] newInterval = {3, 4};

//        int[][] arr = {{1, 2}, {5, 6}};
//        int[] newInterval = {2, 4};

//        int[][] arr = {{1, 2}, {5, 6}};
//        int[] newInterval = {7, 8};

//        int[][] arr = {{1, 2}, {5, 6}};
//        int[] newInterval = {-1, 0};

//        int[][] arr = {{1, 2}, {5, 6}};
//        int[] newInterval = {-1, 8};

        insert(arr, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        int i = 0;
        while(i < intervals.length) {
            newIntervals[i][0] = intervals[i][0];
            newIntervals[i][1] = intervals[i][1];
            i ++;
        }
        newIntervals[i][0] = newInterval[0];
        newIntervals[i][1] = newInterval[1];

        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : newIntervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
