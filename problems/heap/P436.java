package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P436 {

    public static void main(String[] args) {
//        int[][] arr = { { 1, 2 }, { 2, 3 }, { 0, 1 }, { 3, 4 } };
//        int[][] arr = {{1,2}, {2, 3}};
//        int[][] arr = {{1,4},{2,3},{3,4}};
        int[][] arr = {{1,1},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(arr)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> endHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);

        int i = 0;
        for (int[] interval : intervals) {
            startHeap.offer(new int[] { interval[0], i });
            endHeap.offer(new int[] { interval[1], i });
            i++;
        }

        while (!endHeap.isEmpty()) {
            int[] curEnd = endHeap.poll();
            while (!startHeap.isEmpty()) {
                int[] curStart = startHeap.peek();

                if (curStart[0] >= curEnd[0]) {
                    result[curEnd[1]] = curStart[1];
                    break;
                } else {
                    startHeap.poll();
                }
            }
        }

        return result;
    }

}
