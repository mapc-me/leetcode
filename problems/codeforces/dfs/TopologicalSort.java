package codeforces.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {

    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        answer = new ArrayList<>();
//        int[][] graph = {
//            {}
//        };

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(graph, i, visited);
        }

        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i) + 1 + " ");
        }

    }

    public static void dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] != 0 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
        answer.add(node);
    }
}
