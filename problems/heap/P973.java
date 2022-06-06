package heap;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class P973 {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        int[][] res = kClosest(points, k);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double euclideanA = Math.sqrt((a[0] * a[0] + a[1] * a[1]));
            double euclideanB = Math.sqrt((b[0] * b[0] + b[1] * b[1]));
            return Double.compare(euclideanA, euclideanB);
        });

        heap.addAll(Arrays.asList(points));

        int[][] result = new int[k][1];
        for (int i = 0; i < k; i ++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
