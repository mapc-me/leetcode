package codeforces.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticulationPoint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> graph = readGraph(scanner, n, m);
//        List<List<Integer>> graph = List.of(
//            List.of(1, 2),
//            List.of(2, 0),
//            List.of(3, 4, 1, 0),
//            List.of(2, 4),
//            List.of(2, 3)
//
//        );

        int connectedComponents = getNumberOfConnectedComponents(graph);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int connectedComponentsWithoutNode = 0;
            boolean[] used = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (j != i && !used[j]) {
                    connectedComponentsWithoutNode++;
                    dfs(graph, j, i, used);
                }
            }
            if (connectedComponentsWithoutNode > connectedComponents) {
                answer.add(i + 1);
            }
        }

        System.out.println(answer.size());
        for (int node : answer) {
            System.out.print(node + " ");
        }
    }

    public static int getNumberOfConnectedComponents(List<List<Integer>> graph) {
        int ans = 0;
        boolean[] used = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!used[i]) {
                ans++;
                dfs(graph, i, -1, used);
            }
        }

        return ans;
    }

    public static List<List<Integer>> readGraph(Scanner scanner, int n, int m) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int v1 = scanner.nextInt() - 1;
            int v2 = scanner.nextInt() - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return graph;
    }

    public static void dfs(List<List<Integer>> graph, int node, int excludedNode, boolean[] used) {
        if (used[node]) {
            return;
        }

        used[node] = true;
        for (Integer next : graph.get(node)) {
            if (next != excludedNode) {
                dfs(graph, next, excludedNode, used);
            }
        }
    }
}
