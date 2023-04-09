package unionfind;

public class P547Bfc {

    public int findCircleNum(int[][] a) {
        int n = a.length;
        int count = 0;
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(a, used, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] a, boolean[] used, int i) {
        used[i] = true;

        for (int j = 0; j < a.length; j++) {
            if (a[i][j] == 1 && !used[j]) {
                dfs(a, used, j);
            }
        }

    }

}
