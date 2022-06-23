package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P787 {

    public static void main(String[] args) {
//        int[][] arr = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        int[][] arr = {{0,1,100},{1,2,100},{0,2,500}};
        int[][] arr = {{0,1,100},{1,2,100},{0,2,500}};

//        System.out.println(dijkstra(3, arr, 0, 2, 0));
        System.out.println(bellmanFord(3, arr, 0, 2, 0));
    }

    public static int bellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        int[] cur = new int[n];
        for (int i = 0; i <= k; i ++) {
            System.arraycopy(path, 0, cur, 0, n);

            for (int[] edge : flights) {
                int source = edge[0];
                int destination = edge[1];
                int weight = edge[2];
                int candidate = path[source] + weight;
                if (path[source] != Integer.MAX_VALUE && cur[destination] > candidate) {
                    cur[destination] = candidate;
                }
            }

            System.arraycopy(cur, 0, path, 0, n);
        }

        return path[dst];
    }

    public static int dijkstra(int n, int[][] flights, int src, int dst, int k) {
        Integer[][] dest = new Integer[n][k + 2];
        boolean[][] visited = new boolean[n][k + 2];

        dest[src][0] = 0;

        List<int[]>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];
            graph[source].add(new int[]{destination, price});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> dest[a[0]][a[1]] - dest[b[0]][b[1]]);
        heap.offer(new int[]{src, 0});


        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int vertex = current[0];
            int currentRoute = current[1];

            if (visited[vertex][currentRoute]) {
                continue;
            }

            visited[vertex][currentRoute] = true;

            if (vertex == dst || currentRoute > k) {
                continue;
            }

            for (int[] next : graph[vertex]) {
                int v = next[0];
                int price = next[1];
                int candidate = dest[vertex][currentRoute] + price;
                int routeSize = currentRoute + 1;
                if (!visited[v][routeSize] && (dest[v][routeSize] == null || candidate < dest[v][routeSize])) {
                    dest[v][routeSize] = candidate;
                    heap.offer(new int[]{v, routeSize});
                }
            }
        }

        Integer ans = -1;
        for (int i = 0; i <= k + 1; i ++) {
            if (dest[dst][i] == null) {
                continue;
            }
            if (ans == -1) {
                ans = dest[dst][i];
            } else {
                ans = Math.min(ans, dest[dst][i]);
            }
        }

        return ans;
    }
}
