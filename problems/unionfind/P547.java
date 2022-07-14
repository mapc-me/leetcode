package unionfind;

import java.util.HashSet;
import java.util.Set;

public class P547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.findSets();
    }

    public static class DSU {
        private final int[] parent;

        DSU (int n) {
            parent = new int[n];
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }


        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int xIndex = find(x);
            int yIndex = find(y);

            if (xIndex == yIndex) {
                return;
            }

            parent[xIndex] = yIndex;
        }

        public int findSets() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                set.add(find(parent[i]));
            }

            return set.size();
        }
    }
}
