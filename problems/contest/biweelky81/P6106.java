package contest.biweelky81;

import java.util.*;

public class P6106 {

    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{1,2}};

        System.out.println(countPairs(7, arr));

    }

    public static long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        List<Integer> comps = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] v : edges) {
            int source = v[0];
            int target = v[1];
            graph[source].add(target);
            graph[target].add(source);
        }

        for (int i = 0; i < n ; i ++) {
            if (visited.contains(i)) {
                continue;
            }
            Set<Integer> currentVisited = new HashSet<>();
            dfs(i, graph, currentVisited);
            visited.addAll(currentVisited);
            comps.add(currentVisited.size());
        }

        long sum = 0;
        long answer = 0;
        for (Integer s : comps) {
            sum += s;
        }
        for (Integer s : comps) {
            sum -= s;
            answer += s * sum;
        }

        return answer;
    }

    public static void dfs(int v, List<Integer>[] graph, Set<Integer> visited) {
        if (visited.contains(v)) {
            return;
        }
        visited.add(v);
        for (Integer next : graph[v]) {
            dfs(next, graph, visited);
        }
    }

}
