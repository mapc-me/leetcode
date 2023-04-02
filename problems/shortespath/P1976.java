package shortespath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P1976 {

    static class Pair {
        int node;
        long time;

        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] arr =
            { { 3, 0, 4 }, { 0, 2, 3 }, { 1, 2, 2 }, { 4, 1, 3 }, { 2, 5, 5 }, { 2, 3, 1 }, { 0, 4, 1 }, { 2, 4, 6 }, { 4, 3, 1 } };

        countPaths(6, arr);
    }

    public static int countPaths(int n, int[][] roads) {
        int finish = n - 1;

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time));
        }

        long[] path = new long[n];
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));

        heap.add(new Pair(0, 0));

        long modulo = 1_000_000_007;
        long[] dp = new long[n];
        dp[0] = 1;
        path[0] = 0;

        while (!heap.isEmpty()) {
            Pair pair = heap.poll();

            int node = pair.node;
            if (pair.time > path[node]) {
                continue;
            }

            for (Pair v : graph.get(node)) {
                int vertex = v.node;
                long time = v.time;
                long value = path[node] + time;
                if (value < path[vertex] || path[vertex] == 0) {
                    path[vertex] = value;
                    dp[vertex] = dp[node];
                    heap.offer(new Pair(vertex, path[vertex]));
                } else if (value == path[vertex]) {
                    dp[vertex] = (dp[vertex] + dp[node]) % modulo;
                }
            }
        }

        return (int) (dp[finish]);
    }
}
