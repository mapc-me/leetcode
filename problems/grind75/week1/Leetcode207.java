package grind75.week1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode207 {
    final int gray = 1;
    final int black = 2;

    public boolean canFinish(int n, int[][] p) {


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }

        int[] color = new int[n];

        for (int[] edge : p) {
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i ++) {
            if (color[i] != 0) {
                continue;
            }
            if (isCycle(graph, i, color)) {
                return false;
            }
        }

        return true;
    }

    public boolean isCycle(List<List<Integer>> graph, int v, int[] color) {
        color[v] = gray;

        boolean result = false;

        for (Integer n : graph.get(v)) {
            if (color[n] == gray) {
                return true;
            }
            if (color[n] == 0) {
                result |= isCycle(graph, n, color);
            }
        }
        color[v] = black;

        return result;
    }
}
