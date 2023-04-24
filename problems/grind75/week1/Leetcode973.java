package grind75.week1;

import java.util.PriorityQueue;

public class Leetcode973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double distanceA = a[0] * a[0] + a[1] * a[1];
            double distanceB = b[0] * b[0] + b[1] * b[1];

            if (distanceA > distanceB) {
                return 1;
            }
            return -1;
        });

        for (int[] point : points) {
            heap.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i ++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
