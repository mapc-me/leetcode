package grind75.week1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] distance = new int[n][m];

        boolean fresh = false;

        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                    distance[i][j] = 0;
                } else if (!fresh && grid[i][j] == 1) {
                    fresh = true;
                }
            }
        }

        if (queue.isEmpty()) {
            if (fresh) {
                return -1;
            } else {
                return 0;
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int answer = 0;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];

            for (int[] direction : directions) {
                int xx = x + direction[0];
                int yy = y + direction[1];

                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }

                if (distance[xx][yy] == Integer.MAX_VALUE && grid[xx][yy] == 1) {
                    queue.offer(new int[] { xx, yy });
                    distance[xx][yy] = distance[x][y] + 1;
                    answer = Math.max(answer, distance[xx][yy]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && distance[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
            }
        }

        return answer;
    }
}
