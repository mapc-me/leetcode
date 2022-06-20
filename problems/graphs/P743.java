package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P743 {

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

        System.out.println(networkDelayTime(arr, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        k--;
        List<int[]>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int[] timeCalc = new int[n];

        for (int i = 0; i < n; i++) {
            timeCalc[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int[] v : times) {
            int source = v[0] - 1;
            int target = v[1] - 1;
            int time = v[2];
            graph[source].add(new int[]{target, time});
        }


        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (Integer) (timeCalc[a] - timeCalc[b]));

        timeCalc[k] = 0;
        heap.add(k);

        while (!heap.isEmpty()) {
            int vertex = heap.poll();

            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;

            for (int[] next : graph[vertex]) {
                int dest = next[0];
                int time = next[1];
                int candidate = timeCalc[vertex] + time;

                if (candidate < timeCalc[dest]) {
                    timeCalc[dest] = candidate;
                    heap.add(dest);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, timeCalc[i]);
        }

        return ans;
    }
}
