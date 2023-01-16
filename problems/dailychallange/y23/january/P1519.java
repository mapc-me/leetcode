package dailychallange.y23.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1519 {

    static int[] result;

    public static void main(String[] args) {
//        int[][] arr = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        String labels = "abaedcd";
//        int n = 7;

        int[][] arr = {{0,1},{0,2},{1,3},{0,4}};
        String labels = "aabab";
        int n = 5;

        System.out.println(Arrays.toString(countSubTrees(n, arr, labels)));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        result = new int[n];
        dfs(tree, new HashSet<>(), 0, labels);

        return result;
    }

    public static int[] dfs(List<List<Integer>> tree, Set<Integer> visited, int node, String labels) {
        if (visited.contains(node)) {
            return new int[28];
        }
        int[] nodeLabels = new int[28];
        visited.add(node);

        for (int next : tree.get(node)) {
            int[] nodeLabelsRes = dfs(tree, visited, next, labels);
            for (int i = 0; i < 28; i ++) {
                nodeLabels[i] += nodeLabelsRes[i];
            }
        }
        nodeLabels[labels.charAt(node) - 'a'] ++;

        result[node] = nodeLabels[labels.charAt(node) - 'a'];


        return nodeLabels;
    }
}
