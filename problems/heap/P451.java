package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P451 {

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
            } else {
                frequency.put(c, 1);
            }
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a));

        for (Character num : frequency.keySet()) {
            heap.offer(num);
        }

        StringBuilder ans = new StringBuilder();
        while (!heap.isEmpty()) {
            Character chr = heap.poll();
            ans.append(String.valueOf(chr).repeat(Math.max(0, frequency.get(chr))));
        }
        return ans.toString();
    }
}
