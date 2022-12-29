package decemberchallange;

import java.util.PriorityQueue;

public class P1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int pile : piles) {
            heap.offer(pile);
            sum += pile;
        }

        for (int i = 0; i < k; i++) {
            int maximum = heap.poll();
            sum -= maximum;
            int divided = (maximum + 1) / 2;
            heap.offer(divided);
            sum += divided;

        }

        return sum;
    }
}
