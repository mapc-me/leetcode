package sorting.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

    public int[][] heapSolution(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);

        List<int[]> answer = new ArrayList<>();

        for (int[] interval : intervals) {
            if (heap.isEmpty() || heap.peek()[1] >= interval[0]) {
                heap.offer(interval);
            }

            if (heap.peek()[1] < interval[0]) {
                int[] newInterval = new int[2];
                newInterval[0] = Integer.MAX_VALUE;

                while (!heap.isEmpty()) {
                    int[] currentInterval = heap.poll();
                    newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
                    newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                }
                answer.add(newInterval);
                heap.offer(interval);
            }
        }

        if (!heap.isEmpty()) {
            int[] newInterval = new int[2];
            newInterval[0] = Integer.MAX_VALUE;

            while(!heap.isEmpty()) {
                int[] currentInterval = heap.poll();
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
            }
            answer.add(newInterval);
        }

        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i ++) {
            result[i][0] = answer.get(i)[0];
            result[i][1] = answer.get(i)[1];
        }
        return result;
    }
}
