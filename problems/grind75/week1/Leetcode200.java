package grind75.week1;

public class Leetcode200 {
    int n;
    int m;

    int[][] directions = {{-1,0},{0,-1},{1, 0},{0, 1}};

    public int numIslands(char[][] grid) {
        int count = 0;

        n = grid.length;
        m = grid[0].length;

        boolean[][] used = new boolean[n][m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    dfs(grid, i, j, used);
                    count ++;
                }

            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] used) {
        used[i][j] = true;

        for (int[] d : directions) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (ii < 0 || ii >= n || jj < 0 || jj >= m || grid[ii][jj] == '0' || used[ii][jj]) {
                continue;
            }
            dfs(grid, ii, jj, used);
        }
    }
}
