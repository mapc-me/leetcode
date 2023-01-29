package topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class P207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] color = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) {
                boolean cycle = dfs(graph, i, color);
                if (cycle) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int node, int[] color) {
        color[node] = 1;
        for (Integer n : graph.get(node)) {
            if (color[n] == 1) {
                return true;
            }
            if (color[n] == 0) {
                if (dfs(graph, n, color)) {
                    return true;
                }
            }
        }

        color[node] = 2;
        return false;
    }
}
