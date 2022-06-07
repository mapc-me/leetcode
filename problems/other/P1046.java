package other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1046 {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stonesHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());

        for (Integer stone : stones) {
            stonesHeap.add(stone);
        }

        while (stonesHeap.size() > 1) {
            Integer first = stonesHeap.poll();
            Integer second = stonesHeap.poll();
            if (!first.equals(second)) {
                stonesHeap.add(first - second);
            }
        }

        if (stonesHeap.isEmpty()) {
            return 0;
        }
        return stonesHeap.poll();

    }
}
