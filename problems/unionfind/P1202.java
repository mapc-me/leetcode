package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P1202 {

    public static void main(String[] args) {
        String s = "dcab";
        Integer[][] arr = { {0,3}, {1,2}, {0,2}};
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] a : arr) {
            list.add(Arrays.stream(a).collect(Collectors.toList()));
        }
        System.out.println(smallestStringWithSwaps(s, list));
    }


    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU dsu = new DSU(s.length());

        for (List<Integer> swap : pairs) {
            dsu.union(swap.get(0), swap.get(1));
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            int root = dsu.find(i);
            if (!components.containsKey(i)) {
                components.put(root, new ArrayList<>());
            }
            components.get(root).add(i);
        }

        char[] result = new char[s.length()];
        for (List<Integer> componentCandidates : components.values()) {
            List<Character> candidates = new ArrayList<>();
            for (Integer indexCandidate : componentCandidates) {
                candidates.add(s.charAt(indexCandidate));
            }
            Collections.sort(candidates);
            for (int i = 0; i < componentCandidates.size(); i ++) {
                result[componentCandidates.get(i)] = candidates.get(i);
            }
        }

        return String.valueOf(result);
    }


    static class DSU {
        private int[] prev;
        private int[] size;

        public DSU(int n) {
            prev = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i ++) {
                prev[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (i == prev[i]) {
                return i;
            }
            prev[i] = find(prev[i]);
            return prev[i];
        }

        public void union(int x, int y) {
            int xIdx = find(x);
            int yIdx = find(y);

            if (xIdx == yIdx) {
                return;
            }

            if (size[xIdx] > size[yIdx]) {
                prev[yIdx] = xIdx;
            } else {
                prev[xIdx] = yIdx;
            }
        }
    }

}
