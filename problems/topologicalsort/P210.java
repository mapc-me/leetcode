package topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P210 {
    LinkedList<Integer> topologicalSort = new LinkedList<>();

    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] color = new int[n];

        for (int i = 0; i < n; i ++) {
            if (color[i] == 0) {
                boolean cycle = dfs(graph, i, color);
                if (cycle) {
                    return new int[0];
                }
            }
        }

        return topologicalSort.stream().mapToInt(i->i).toArray();
    }

    public boolean dfs(List<List<Integer>> graph, int node, int[] color) {
        color[node] = 1;

        for (Integer next : graph.get(node)) {
            if (color[next] == 1) {
                return true;
            }
            if (color[next] == 0) {
                if (dfs(graph, next, color)) {
                    return true;
                }
            }
        }

        color[node] = 2;
        topologicalSort.addFirst(node);
        return false;

    }
}
