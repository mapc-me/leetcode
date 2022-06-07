package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347 {

    public static void main(String[] args) {
        int[] arr = {1};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (Integer num : nums) {
            if (!frequency.containsKey(num)) {
                frequency.put(num, 1);
            } else {
                frequency.put(num, frequency.get(num) + 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a));
        for (Integer num : frequency.keySet()) {
            queue.offer(num);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}
