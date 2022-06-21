package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

//SOLVED WRONG (can't understand why)
public class P1631 {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int[][] arr = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
//        int[][] arr = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(minimumEffortPath(arr));
    }

    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        int[][] difference = new int[rows][columns];

        for (int[] effort : difference) Arrays.fill(difference, Integer.MAX_VALUE);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int ai = a[0];
            int aj = a[1];
            int bi = b[0];
            int bj = b[1];
            return difference[ai][aj] - difference[bi][bj];
        });

        heap.offer(new int[]{rows - 1, columns - 1});
        difference[rows - 1][columns - 1] = 0;

        int x, y, newX, newY, candidate;
        int[] coordinate;
        while (!heap.isEmpty()) {
            coordinate = heap.poll();
            x = coordinate[0];
            y = coordinate[1];

            if (x == 0 && y == 0) {
                return difference[x][y];
            }

            for (int[] dir : DIRECTIONS) {
                newX = x + dir[0];
                newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= rows || newY >= columns) continue;
                candidate = Math.max(difference[x][y], Math.abs(heights[x][y] - heights[newX][newY]));
                if (difference[newX][newY] > candidate) {
                    difference[newX][newY] = candidate;
                    heap.offer(new int[]{newX, newY});
                }
            }
        }
        return 0;
    }
}
