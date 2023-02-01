package topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class P802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> answer = new ArrayList<>();
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 1) {
                continue;
            }

            if (color[i] == 2 || !dfs(graph, i, color)) {
                answer.add(i);
            }
        }

        return answer;

    }

    public boolean dfs(int[][] graph, int node, int[] color) {
        color[node] = 1;

        for (int v : graph[node]) {
            if (color[v] == 1) {
                return true;
            }
            if (color[v] == 0 && dfs(graph, v, color)) {
                return true;
            }
        }

        color[node] = 2;
        return false;
    }
}
