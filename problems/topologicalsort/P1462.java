package topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class P1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] vertices : p) {
            graph.get(vertices[0]).add(vertices[1]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[n];
            dfs(graph, i, i, used, connected);
        }

        for (int[] q : queries) {
            answer.add(connected[q[0]][q[1]]);
        }

        return answer;
    }

    public void dfs(List<List<Integer>> graph, int start, int n, boolean[] used, boolean[][] connected) {
        used[n] = true;

        for (int node : graph.get(n)) {
            if (used[node]) {
                continue;
            }
            connected[start][node] = true;
            dfs(graph, start, node, used, connected);
        }
    }
}
