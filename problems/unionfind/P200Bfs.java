package unionfind;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class P200Bfs {

    public static void main(String[] args) {
//        char[][] grid = {
//            {'1', '1', '0', '0', '0'},
//            {'1', '1', '0', '0', '0'},
//            {'0', '0', '1', '0', '0'},
//            {'0', '0', '0', '1', '1'}
//        };

        char[][] grid = {
            { '1', '1', '1' },
            { '0', '1', '0' },
            { '1', '1', '1' }
        };

//        char[][] grid = {
//            { '1', '1', '1', '1', '0' },
//            { '1', '1', '0', '1', '0' },
//            { '1', '1', '0', '0', '0' },
//            { '0', '0', '0', '0', '0' }
//        };

        numIslands(grid);

    }

    static List<Set<Integer>> sets = new ArrayList<>();
    static int[] roots;

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        int[][] used = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (used[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, used, i, j);
                count++;
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int[][] used, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        used[i][j] = 1;
        if (i < grid.length - 1) {
            dfs(grid, used, i + 1, j);
        }

        if (i > 0) {
            dfs(grid, used, i - 1, j);
        }

        if (j > 0) {
            dfs(grid, used, i, j - 1);
        }

    }

}
