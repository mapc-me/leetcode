package unionfind;

public class P695 {

    public static void main(String[] args) {
//        int[][] arr = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
//        int[][] arr = {{0,0,0,0,0,0,0,0}};
        int[][] arr = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(maxAreaOfIsland(arr));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int n = grid.length;
        int m = grid[0].length;

        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(grid, n, m);

        int x1, y1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }

                for (int[] dir : direction) {
                    x1 = x + dir[0];
                    y1 = y + dir[1];
                    if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= m) continue;
                    if (grid[x1][y1] == 1) {
                        disjointUnionSet.union(x * m + y, x1 * m + y1);
                    }
                }
            }
        }

        return disjointUnionSet.getMaximumSet();
    }


    public static class DisjointUnionSet {
        int[] parents;
        int[] size;

        public DisjointUnionSet(int[][] grid, int n, int m) {
            parents = new int[n * m];
            size = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        parents[i * m + j] = i * m + j;
                        size[i * m + j] = 1;
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
            parents[xIsland] = yIsland;
            size[yIsland] += size[xIsland];
        }

        public int getMaximumSet() {
            int max = 0;
            for (Integer s : size) {
                max = Math.max(max, s);
            }
            return max;
        }
    }
}

