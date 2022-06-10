package sorting.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1094 {
    public boolean heapSolution(int[][] trips, int capacity) {

        Arrays.sort(trips, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[2]));

        for (int[] trip : trips) {
            while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) {
                capacity += heap.poll()[0];
            }

            capacity -= trip[0];
            heap.offer(trip);
            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean fastestSolution(int[][] trips, int capacity) {
        int[] from = new int[1000 + 1];
        int[] to = new int[1000 + 1];

        int maxDestination = 0;
        for (int[] trip : trips) {
            from[trip[1]] += trip[0];
            to[trip[2]] += trip[0];
            maxDestination = Math.max(trip[2], maxDestination);
        }


        boolean available = true;
        for (int i = 0; i <= maxDestination; i++) {
            capacity += to[i];
            if (capacity >= from[i]) {
                capacity -= from[i];
            } else {
                available = false;
            }
        }

        return available;
    }
}
