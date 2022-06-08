package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int abs = Math.abs(a - x) - Math.abs(b - x);
            if (abs == 0) {
                return a - b;
            } else {
                return abs;
            }
        });

        for (Integer num : arr) {
            heap.offer(num);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i ++) {
            ans.add(heap.poll());
        }

        Collections.sort(ans);
        return ans;
    }
}
