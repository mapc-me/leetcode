package codeforces.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcyclicCheck {
    static int[] path;
    static int start;
    static int finish;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int graphs = scanner.nextInt();

        for (int i = 0; i < graphs; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < m; j++) {
                int s = scanner.nextInt() - 1;
                int f = scanner.nextInt() - 1;
                graph.get(s).add(f);
            }
            findCycle(graph, n);
        }
    }

    public static void findCycle(List<List<Integer>> graph, int n) {
        int[] visited = new int[n];
        path = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (findCycle(graph, i, visited)) {
                    System.out.println("NO");
                    List<Integer> cycle = new ArrayList<>();

                    cycle.add(start + 1);
                    while (finish != start) {
                        cycle.add(finish + 1);
                        finish = path[finish];
                    }
                    cycle.add(start + 1);

                    System.out.println(cycle.size() - 1);
                    for (int j = cycle.size() - 1; j >= 0; j--) {
                        System.out.print(cycle.get(j) + " ");
                    }
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static boolean findCycle(List<List<Integer>> graph, int node, int[] visited) {

        visited[node] = 1;
        for (int n : graph.get(node)) {
            if (visited[n] == 1) {
                start = n;
                finish = node;
                return true;
            }
            if (visited[n] == 0) {
                path[n] = node;
                if (findCycle(graph, n, visited)) {
                    return true;
                }
            }
        }
        visited[node] = 2;

        return false;
    }
}
