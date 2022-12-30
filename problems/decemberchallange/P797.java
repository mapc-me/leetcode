package decemberchallange;

import java.util.ArrayList;
import java.util.List;

public class P797 {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<>(), graph.length - 1);
        return answer;
    }

    public void dfs(int[][] graph, int v, List<Integer> path, int finish) {
        path.add(v);
        if (v == finish) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int edge : graph[v]) {
            dfs(graph, edge, path, finish);
            path.remove(path.size() - 1);
        }

    }
}
