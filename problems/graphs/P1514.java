package graphs;

import java.util.*;

public class P1514 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        double[] prob = {0.2, 0.1, 1};
//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        double[] prob = {0.5, 0.5, 0.3};
        System.out.println(maxProbability(3, edges, prob, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        boolean[] visited = new boolean[n];
        final int INFINITY = 2;
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i ++) {
            graph[i] = new ArrayList<>();
        }

        double[] path = new double[n];

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Double.compare(path[b], path[a]));

        int k = 0;
        for (int[] e : edges) {
            int source = e[0];
            int dest = e[1];

            graph[source].add(new int[]{dest, k});
            graph[dest].add(new int[]{source, k});

            k++;
        }

        path[start] = 1;
        heap.offer(start);

        while (!heap.isEmpty()) {
            Integer maxProbabilityVertex = heap.poll();
            if (maxProbabilityVertex == end) {
                return path[maxProbabilityVertex];
            }
            if (visited[maxProbabilityVertex]) {
                continue;
            }
            visited[maxProbabilityVertex] = true;

            for (int[] edge : graph[maxProbabilityVertex]) {
                int vertex = edge[0];
                double probability = succProb[edge[1]];

                double probabilityCandidate = path[maxProbabilityVertex] * probability;
                if (path[vertex] < probabilityCandidate) {
                    path[vertex] = probabilityCandidate;
                    heap.offer(vertex);
                }
            }
        }

        return 0;
    }
}
