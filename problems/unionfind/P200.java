package unionfind;

import java.util.*;

public class P200 {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
        char[][] grid = {
                {'0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        Map<Map.Entry<Integer, Integer>, Map.Entry<Integer, Integer>> usedValues = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> used = new HashSet<>();
        List<Map.Entry<Integer, Integer>> islands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                islands.add(new AbstractMap.SimpleEntry<>(i, j));
            }
        }
        DisjointUnionSet dsu = new DisjointUnionSet(islands);

        for (Map.Entry<Integer, Integer> island : islands) {
            AbstractMap.SimpleEntry<Integer, Integer> upCandidate = new AbstractMap.SimpleEntry<>(island.getKey() - 1, island.getValue());
            AbstractMap.SimpleEntry<Integer, Integer> downCandidate = new AbstractMap.SimpleEntry<>(island.getKey() + 1, island.getValue());
            AbstractMap.SimpleEntry<Integer, Integer> leftCandidate = new AbstractMap.SimpleEntry<>(island.getKey(), island.getValue() - 1);
            AbstractMap.SimpleEntry<Integer, Integer> rightCandidate = new AbstractMap.SimpleEntry<>(island.getKey(), island.getValue() + 1);
            if (used.contains(upCandidate)) {
                dsu.union(upCandidate, island);
            }
            if (used.contains(downCandidate)) {
                dsu.union(downCandidate, island);
            }
            if (used.contains(leftCandidate)) {
                dsu.union(leftCandidate, island);
            }
            if (used.contains(rightCandidate)) {
                dsu.union(rightCandidate, island);
            }
            used.add(island);
        }


        return dsu.calculateNumberOfSets();
    }

    public static class DisjointUnionSet {
        Map<Map.Entry<Integer, Integer>, Map.Entry<Integer, Integer>> parents = new HashMap<>();

        public DisjointUnionSet(List<Map.Entry<Integer, Integer>> islands) {
            islands.forEach(island -> parents.put(island, island));
        }

        public Map.Entry<Integer, Integer> find(Map.Entry<Integer, Integer> island) {
            if (parents.get(island).equals(island)) {
                return island;
            }
            Map.Entry<Integer, Integer> found = find(parents.get(island));
            parents.put(island, found);
            return found;
        }

        public void union(Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y) {
            Map.Entry<Integer, Integer> xIsland = find(x);
            Map.Entry<Integer, Integer> yIsland = find(y);

            if (xIsland.equals(yIsland)) {
                return;
            }

            parents.put(xIsland, yIsland);
        }

        public int calculateNumberOfSets() {
            int result = 0;
            for (Map.Entry<Integer, Integer> value : parents.keySet()) {
                if (value.equals(parents.get(value))) {
                    result++;
                }
            }
            return result;
        }
    }


}
