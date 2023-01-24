package codeforces.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Dfs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int start = in.nextInt() - 1;
        int finish = in.nextInt() - 1;

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }

//        int[][] graph = {
//            { 0, 0, 0, 0, 1 },
//            { 1, 0, 0, 1, 1 },
//            { 1, 0, 0, 0, 1 },
//            { 0, 1, 0, 0, 1 },
//            { 1, 1, 1, 1, 0 }
//        };
//        int n = 5;
//        int start = 0;
//        int finish = 4;

        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[start] = start;

        dfs(graph, start, finish, path);

        LinkedList<Integer> ans = new LinkedList<>();

        int next = finish;
        while (next != -1 && next != start) {
            ans.addFirst(next + 1);
            next = path[next];
        }

        if (next == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans.size());
            ans.addFirst(start + 1);
            for (int node : ans) {
                System.out.print(node + " ");
            }
        }
    }

    public static void dfs(int[][] graph, int v, int finish, int[] path) {
        if (path[finish] != -1) {
            return;
        }

        for (int i = 0; i < graph[v].length; i++) {
            if (graph[v][i] != 0 && path[i] == -1) {
                path[i] = v;
                dfs(graph, i, finish, path);
            }
        }
    }
}
