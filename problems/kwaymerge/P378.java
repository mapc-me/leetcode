package kwaymerge;

import java.util.PriorityQueue;

public class P378 {
    public int kthSmallest(int[][] m, int k) {
        final int n = m.length;

        PriorityQueue<Touple> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int j = 0; j < n; j ++) {
            heap.offer(new Touple(0, j, m[0][j]));
        }


        while(true) {
            if (k == 1) {
                return heap.poll().val;
            }

            Touple t = heap.poll();

            k--;

            if (t.i < n - 1) {
                heap.offer(new Touple(t.i + 1, t.j, m[t.i + 1][t.j]));
            }
        }
    }

    class Touple {
        int i;
        int j;
        int val;

        public Touple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

    }
}
