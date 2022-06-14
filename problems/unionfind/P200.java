package unionfind;

public class P200 {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
//        char[][] grid = {
//                {'0'}
//        };
//        char[][] grid = {{
//                '1', '0', '0', '1', '1'}, {
//                '1', '0', '1', '0', '0'}
//        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        DisjointUnionSet dsu = new DisjointUnionSet(grid, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int upCandidate = (i - 1) * m + j;
                int downCandidate = (i + 1) * m + j;
                int rightCandidate = i * m + j + 1;
                int leftCandidate = i * m + j - 1;
                int current = i * m + j;

                if (i > 0 && grid[i - 1][j] == '1') {
                    dsu.union(upCandidate, current);
                }
                if (i < n - 1 && grid[i + 1][j] == '1') {
                    dsu.union(downCandidate, current);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    dsu.union(leftCandidate, current);
                }
                if (j < m - 1 && grid[i][j + 1] == '1') {
                    dsu.union(rightCandidate, current);
                }
            }
        }

        return dsu.count;
    }

    public static class DisjointUnionSet {
        int[] parents;
        int count = 0;

        public DisjointUnionSet(char[][] grid, int n, int m) {
            parents = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * m + j] = i * m + j;
                        count++;
                    }
                }
            }
        }

        public int find(int island) {
            if (parents[island] == island) {
                return island;
            }
            return parents[island] = find(parents[island]);
        }

        public void union(int x, int y) {
            int xIsland = find(x);
            int yIsland = find(y);

            if (xIsland == yIsland) {
                return;
            }

            count--;
            parents[xIsland] = yIsland;
        }
    }
}
