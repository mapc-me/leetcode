package kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P373 {
    class Pair {
        int i;
        int j;
        int sum;

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        final int n = a.length;
        final int m = b.length;

        PriorityQueue<Pair> heap = new PriorityQueue<>((a1, b1) -> a1.sum - b1.sum);

        for (int j = 0; j < m; j ++) {
            heap.offer(new Pair(0, j, a[0] + b[j]));
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (!heap.isEmpty() && k > 0) {

            Pair p = heap.poll();

            ans.add(List.of(a[p.i], b[p.j]));

            k--;

            if (p.i < n - 1) {
                heap.offer(new Pair(p.i + 1, p.j, a[p.i + 1] + b[p.j]));
            }
        }

        return ans;
    }
}
