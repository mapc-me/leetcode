package shortespath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Could be optimized. Now it's not fastest.
 */
public class P1976 {

    public static void main(String[] args) {
        int[][] arr =
            { { 3, 0, 4 }, { 0, 2, 3 }, { 1, 2, 2 }, { 4, 1, 3 }, { 2, 5, 5 }, { 2, 3, 1 }, { 0, 4, 1 }, { 2, 4, 6 }, { 4, 3, 1 } };

        countPaths(6, arr);
    }

    public static int countPaths(int n, int[][] roads) {
        int finish = n - 1;

        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph.get(u).put(v, time);
            graph.get(v).put(u, time);
        }

        int[] path = new int[n];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        heap.add(new int[] { 0, 0 });

        long modulo = 1_000_000_007;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        Arrays.fill(path, -1);
        dp[0] = 1;
        path[0] = 0;

        while (!heap.isEmpty()) {
            int[] arr = heap.poll();
            int node = arr[0];
            int p = arr[1];

            if (p > path[node]) {
                continue;
            }

            for (Integer v : graph.get(node).keySet()) {
                int value = path[node] + graph.get(node).get(v);
                if (value < path[v] || path[v] == -1) {
                    path[v] = value;
                    dp[v] = dp[node];
                    heap.offer(new int[] { v, path[v] });
                } else if (value == path[v]) {
                    dp[v] = (dp[v] + dp[node]) % modulo;
                }
            }
        }

        return (int) (dp[finish]);
    }
}
