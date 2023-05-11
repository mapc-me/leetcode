package kwaymerge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int b : barcodes) {
            counter.put(b, counter.getOrDefault(b, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            if (counter.get(a) == counter.get(b)) {
                return a - b;
            } else {
                return counter.get(b) - counter.get(a);
            }
        });

        for (Integer i : counter.keySet()) {
            heap.offer(i);
        }

        int[] answer = new int[barcodes.length];
        int i = 0;

        while(i < barcodes.length - 1) {

            int first = heap.poll();
            int second = heap.poll();

            answer[i ++] = first;
            answer[i ++] = second;


            counter.put(first, counter.get(first) - 1);
            counter.put(second, counter.get(second) - 1);

            heap.offer(first);
            heap.offer(second);
        }

        if (i == barcodes.length - 1) {
            answer[i] = heap.poll();
        }

        return answer;
    }
}
