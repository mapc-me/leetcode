package topologicalsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() <= 1) {
                leaves.add(i);
            }
        }

        int nodes = n;

        while (nodes > 2) {
            nodes -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf : leaves) {
                Integer neighbour = graph.get(leaf).iterator().next();
                graph.get(neighbour).remove(leaf);
                if (graph.get(neighbour).size() == 1) {
                    newLeaves.add(neighbour);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
