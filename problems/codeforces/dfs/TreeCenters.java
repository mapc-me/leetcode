package codeforces.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreeCenters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<List<Integer>> graph = readGraph(scanner, n);
//        List<List<Integer>> graph = List.of(
//            List.of()
//        );

        int min = -1;
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            int[] distance = new int[graph.size()];
            Arrays.fill(distance, -1);
            distance[i] = 0;
            int currentMaxDistance = getMaxDistance(graph, i, distance);
            if (min == -1 || currentMaxDistance == min) {
                vertices.add(i + 1);
                min = currentMaxDistance;
            } else {
                if (min == -1 || currentMaxDistance < min) {
                    min = currentMaxDistance;
                    vertices.clear();
                    vertices.add(i + 1);
                }
            }
        }

        System.out.println(vertices.size());
        for (Integer vertex : vertices) {
            System.out.print(vertex + " ");
        }
    }

    public static List<List<Integer>> readGraph(Scanner scanner, int n) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int v1 = scanner.nextInt() - 1;
            int v2 = scanner.nextInt() - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return graph;
    }

    public static int getMaxDistance(List<List<Integer>> graph, int node, int[] distance) {
        int max = distance[node];
        for (int next : graph.get(node)) {
            if (distance[next] == -1) {
                distance[next] = distance[node] + 1;
                max = Math.max(getMaxDistance(graph, next, distance), max);
            }
        }
        return max;
    }
}
