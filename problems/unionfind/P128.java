package unionfind;

import java.util.HashMap;
import java.util.Map;

public class P128 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 1, 2, 3, 4};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        UF unionFined = new UF(nums.length);

        Map<Integer, Integer> numberIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (numberIndexMap.containsKey(nums[i])) {
                continue;
            }

            if (numberIndexMap.containsKey(currentNumber + 1)) {
                unionFined.union(i, numberIndexMap.get(currentNumber + 1));
            }

            if (numberIndexMap.containsKey(currentNumber - 1)) {
                unionFined.union(i, numberIndexMap.get(currentNumber - 1));
            }

            numberIndexMap.put(currentNumber, i);
        }

        return unionFined.getMaxSet();
    }


    private static class UF {
        private final int[] parent;
        private final int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int idx) {
            if (parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public void union(int xIdx, int yIdx) {
            int rootX = find(xIdx);
            int rootY = find(yIdx);
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int getMaxSet() {
            int max = 0;
            for (int num : size) {
                if (num > max) {
                    max = num;
                }
            }

            return max;
        }
    }
}
