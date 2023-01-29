package dfs;

import java.util.ArrayList;
import java.util.List;

public class P1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] used = new boolean[n];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(graph, source, used);

        return used[destination];
    }

    public void dfs(List<List<Integer>> graph, int node, boolean[] used) {
        used[node] = true;
        for (Integer n : graph.get(node)) {
            if (!used[n]) {
                dfs(graph, n, used);
            }
        }
    }
}
