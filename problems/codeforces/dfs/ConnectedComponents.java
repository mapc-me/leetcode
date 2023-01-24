package codeforces.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConnectedComponents {
    static int componentNumber = 0;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

//        int n = 5;
//        int m = 2;
//
//        List<List<Integer>> graph = List.of(
//            List.of(1,2),
//            List.of(0),
//            List.of(0,3),
//            List.of(2),
//            List.of()
//        );

        int[] result = findConnectedComponents(graph);

        System.out.println(componentNumber);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] findConnectedComponents(List<List<Integer>> graph) {
        int[] connectedComponents = new int[graph.size()];
        Arrays.fill(connectedComponents, -1);

        for (int i = 0; i < graph.size(); i++) {
            if (connectedComponents[i] == -1) {
                componentNumber++;
                dfs(graph, i, connectedComponents, componentNumber);
            }
        }

        return connectedComponents;
    }

    public static void dfs(List<List<Integer>> graph, Integer node, int[] connectedComponents, Integer componentNumber) {
        if (connectedComponents[node] != -1) {
            return;
        }

        connectedComponents[node] = componentNumber;
        for (Integer n : graph.get(node)) {
            dfs(graph, n, connectedComponents, componentNumber);
        }
    }
}
