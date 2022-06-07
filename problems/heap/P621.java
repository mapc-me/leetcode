package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P621 {

    public static void main(String[] args) {
//        char[] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//        char[] arr = {'A','A','A','B','B','B'};
//        char[] arr = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C'};
//        char[] arr = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'};
//        char[] arr = {'A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'};
        char[] arr = {'A','B','C','D','A','B','V'};
        int k = 3;
        System.out.println(leastInterval(arr, k));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            if (frequencyMap.containsKey(task)) {
                frequencyMap.put(task, frequencyMap.get(task) + 1);
            } else {
                frequencyMap.put(task, 1);
            }
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        frequencyMap.keySet().forEach(maxHeap::offer);

        int answer = 0;

        while (maxHeap.size() > n) { //100
            for (int i = 0; i < n + 1; i++) { //100
                if (frequencyMap.get(maxHeap.peek()) == 1) {
                    frequencyMap.remove(maxHeap.poll());
                } else {
                    frequencyMap.put(maxHeap.peek(), frequencyMap.get(maxHeap.poll()) - 1);
                }
            }
            answer += n + 1;
            maxHeap.clear();
            frequencyMap.keySet().forEach(maxHeap::offer);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        frequencyMap.values().forEach(minHeap::offer);

        int gapsCount = n + 1 - minHeap.size();
        int prevGapsCount = n + 1 - minHeap.size();
        int prevCount = 0;

        while (!minHeap.isEmpty()) {
            if (minHeap.size() > 1 && minHeap.peek() - prevCount == 0) {
                minHeap.poll();
                gapsCount ++;
                continue;
            }
            if (minHeap.size() == 1 && minHeap.peek() - prevCount == 0) {
                answer -= prevGapsCount - 1;
                break;
            }
            if (minHeap.size() == 1) {
                answer += (n + 1) * (minHeap.peek() - prevCount - 1) + 1;
            } else {
                answer += (n + 1) * (minHeap.peek() - prevCount);
            }
            prevCount = minHeap.poll();
            gapsCount++;
            prevGapsCount = gapsCount;
        }
        return answer;
    }
}

//A A A A A A B B B B C C = 3
//A B C * A B C * A B * * A B * * A * * * A
// C = 2 (2) n = 1
// B = 4 (4)
// A = 3 (5)
//n = 3
//count(C) * (n - 3 + 1 (no -1 because it's start) = 2 * 1 = 2
//count(B) - count(C) * (n - 2 + 1) = (4 - 2 + 1 - 1) * 2 = 4
//count(A) - count(C) - count(B) * (n - 3 + 1 - 1) = 6 - 4 * 3 = 6


///A A A B B B = 2

// A B * A B * A B