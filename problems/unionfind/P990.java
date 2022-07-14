package unionfind;

public class P990 {

    public static void main(String[] args) {
        String[] arr = { "a==b", "b!=c", "c==a" };
        System.out.println(equationsPossible(arr));
    }

    public static boolean equationsPossible(String[] equations) {
        DSU connected = new DSU();
        DSU notConnected = new DSU();
        final int START = 97;

        for (String str : equations) {
            int first = ((int) str.charAt(0)) - START;
            int second = ((int) str.charAt(3)) - START;
            if (str.contains("==")) {
                connected.union(first, second);
            }
        }
        for (String str : equations) {
            int first = ((int) str.charAt(0)) - START;
            int second = ((int) str.charAt(3)) - START;
            if (str.contains("!=")) {
                if (connected.isOneSet(first, second)) {
                    return false;
                }
                notConnected.union(first, second);
            }
        }

        return true;
    }

    static class DSU {
        int[] parent = new int[26];

        DSU() {
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            parent[i] = find(parent[i]);
            return parent[i];
        }

        void union(int x, int y) {
            int idxX = find(x);
            int idxY = find(y);

            parent[idxX] = idxY;
        }

        boolean isOneSet(int x, int y) {
            int idxX = find(x);
            int idxY = find(y);

            return idxX == idxY;
        }
    }
}

