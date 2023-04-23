package grind75.week1;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
    int n;
    int m;

    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i,j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] vertex = q.poll();
            int x = vertex[0];
            int y = vertex[1];

            for (int[] d : directions) {
                int xx = x + d[0];
                int yy = y + d[1];

                if (xx < 0 || yy < 0 || xx >= n || yy >= m || mat[xx][yy] != Integer.MAX_VALUE) {
                    continue;
                }

                mat[xx][yy] = mat[x][y] + 1;
                q.add(new int[]{xx, yy});
            }
        }

        return mat;
    }
}
